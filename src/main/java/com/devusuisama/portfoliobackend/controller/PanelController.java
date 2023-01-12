package com.devusuisama.portfoliobackend.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devusuisama.portfoliobackend.model.EPerfil;
import com.devusuisama.portfoliobackend.model.Perfil;
import com.devusuisama.portfoliobackend.model.Usuario;
import com.devusuisama.portfoliobackend.payload.response.MessageResponse;
import com.devusuisama.portfoliobackend.payload.response.UsuariosResponse;
import com.devusuisama.portfoliobackend.service.interfaces.IPerfilService;
import com.devusuisama.portfoliobackend.service.interfaces.IPortfolioService;
import com.devusuisama.portfoliobackend.service.interfaces.IUsuarioService;

@RestController
@RequestMapping("/api/panel")
public class PanelController {
    @Autowired
    IUsuarioService iUsuarioService;
    @Autowired
    IPerfilService iPerfilService;
    @Autowired
    IPortfolioService iPortfolioService;

    @PostMapping("/user/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateUsuario(@RequestParam int id, @RequestParam List<String> perfil) {
        Usuario usuario = iUsuarioService.buscarUsuarioPorID(id);
        Set<Perfil> _perfil = new HashSet<>();
        perfil.forEach((e) -> {
            if (e.compareTo("ROLE_ADMIN") == 0)
                _perfil.add(iPerfilService.buscarPorRol(EPerfil.ROLE_ADMIN));
            else
                _perfil.add(iPerfilService.buscarPorRol(EPerfil.ROLE_USER));
        });
        usuario.setPerfiles(_perfil);
        iUsuarioService.guardar(usuario);
        return ResponseEntity.ok(new MessageResponse("User update successfully!"));
    }

    @DeleteMapping("user/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteUsuario(@PathVariable int id) {
        Usuario usuario = iUsuarioService.buscarUsuarioPorID(id);
        iPortfolioService.eliminarPorID(usuario.getPortfolio().getId());
        iPortfolioService.eliminarAcercaDePorID(usuario.getPortfolio().getAcercaDe().getId());
        iPortfolioService.eliminarDetallePorID(usuario.getPortfolio().getDetalle().getId());
        iUsuarioService.eliminarUsuarioPorID(id);
        return ResponseEntity.ok(new MessageResponse("User delete successfully!"));
    }

    @GetMapping("/user/get_all_usuarios")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllUsuarios() {
        List<UsuariosResponse> usuariosResponse = new ArrayList<>();
        iUsuarioService.obtenerTodosLosUsuarios().forEach((e) -> {
            usuariosResponse.add(new UsuariosResponse(e));
        });
        return ResponseEntity.ok(usuariosResponse);
    }
}
