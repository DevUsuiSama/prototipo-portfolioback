package com.devusuisama.portfoliobackend.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devusuisama.portfoliobackend.model.AcercaDe;
import com.devusuisama.portfoliobackend.model.Detalle;
import com.devusuisama.portfoliobackend.model.EPerfil;
import com.devusuisama.portfoliobackend.model.Perfil;
import com.devusuisama.portfoliobackend.model.Portfolio;
import com.devusuisama.portfoliobackend.model.Usuario;
import com.devusuisama.portfoliobackend.payload.request.LoginRequest;
import com.devusuisama.portfoliobackend.payload.request.SignupRequest;
import com.devusuisama.portfoliobackend.payload.response.JwtResponse;
import com.devusuisama.portfoliobackend.payload.response.MessageResponse;
import com.devusuisama.portfoliobackend.security.jwt.JwtUtils;
import com.devusuisama.portfoliobackend.security.services.UserDetailsImpl;
import com.devusuisama.portfoliobackend.service.interfaces.IPerfilService;
import com.devusuisama.portfoliobackend.service.interfaces.IPortfolioService;
import com.devusuisama.portfoliobackend.service.interfaces.IUsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    IUsuarioService iUsuarioService;

    @Autowired
    IPerfilService iPerfilService;

    @Autowired
    IPortfolioService iPortfolioService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (iUsuarioService.existeElNombreDeUsuario(signUpRequest.getUsername()))
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse("Error: ¡Este nombre de usuario ya está en uso!"));

        if (iUsuarioService.existeElEmail(signUpRequest.getEmail()))
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Error: ¡Email ya está en uso!"));

        if (iUsuarioService.obtenerTodosLosUsuarios().isEmpty()) {
            Set<String> perfilDefault = new HashSet<String>();
            perfilDefault.add("USER");
            perfilDefault.add("ADMIN");
            signUpRequest.setPerfiles(perfilDefault);
        }

        Usuario usuario = new Usuario();
        usuario.setNombreDeUsuario(signUpRequest.getUsername());
        usuario.setEmail(signUpRequest.getEmail());
        usuario.setClave(encoder.encode(signUpRequest.getPassword()));

        Set<String> strPerfiles = signUpRequest.getPerfiles();
        Set<Perfil> perfiles = new HashSet<>();

        if (strPerfiles == null) {
            Perfil perfilUsuario = iPerfilService.buscarPorRol(EPerfil.ROLE_USER);
            perfiles.add(perfilUsuario);
        } else {
            strPerfiles.forEach(perfil -> {
                switch (perfil) {
                    case "ADMIN":
                        Perfil perfilAdmin = iPerfilService.buscarPorRol(EPerfil.ROLE_ADMIN);
                        perfiles.add(perfilAdmin);
                        break;
                    default:
                        Perfil perfilUsuario = iPerfilService.buscarPorRol(EPerfil.ROLE_USER);
                        perfiles.add(perfilUsuario);
                }
            });
        }

        Portfolio portfolio = new Portfolio();
        usuario.setPerfiles(perfiles);
        portfolio.setDetalle(iPortfolioService.guardarDetalle(new Detalle()));
        portfolio.setAcercaDe(iPortfolioService.guardarAcercaDe(new AcercaDe()));
        usuario.setPortfolio(iPortfolioService.guardar(portfolio));
        iUsuarioService.guardar(usuario);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @GetMapping("/get_all_usuario")
    public List<String> getAllUsuario() {
        return iUsuarioService.obtenerTodosLosNombreDeUsuariosConRolAdministrador();
    }

}
