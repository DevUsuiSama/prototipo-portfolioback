package com.devusuisama.portfoliobackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devusuisama.portfoliobackend.repository.UsuarioRepository;
import com.devusuisama.portfoliobackend.service.interfaces.IUsuarioService;
import com.devusuisama.portfoliobackend.model.EPerfil;
import com.devusuisama.portfoliobackend.model.Usuario;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<String> obtenerTodosLosNombreDeUsuariosConRolAdministrador() {
        List<String> nombreDeUsuario = new ArrayList<String>();
        usuarioRepository.findAll().forEach((e) -> {
            e.getPerfiles().forEach((e2) -> {
                if (e2.getRol() == EPerfil.ROLE_ADMIN)
                    nombreDeUsuario.add(e.getNombreDeUsuario());
            });
        });
        return nombreDeUsuario;
    }

    @Override
    public Boolean existeElNombreDeUsuario(String nombreDeUsuario) {
        return usuarioRepository.existsByNombreDeUsuario(nombreDeUsuario);
    }

    @Override
    public Boolean existeElEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuarioPorID(int id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Boolean existeLaClave(String clave) {
        return usuarioRepository.existsByClave(clave);
    }

    @Override
    public Usuario buscarUsuarioPorNombreDeUsuario(String nombreDeUsuario) throws UsernameNotFoundException {
        return usuarioRepository.findByNombreDeUsuario(nombreDeUsuario)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + nombreDeUsuario));
    }

    @Override
    public Usuario buscarUsuarioPorID(int id) throws UsernameNotFoundException {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with id: " + id));
    }

}
