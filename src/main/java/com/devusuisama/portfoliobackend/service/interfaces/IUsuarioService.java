package com.devusuisama.portfoliobackend.service.interfaces;

import java.util.List;

import com.devusuisama.portfoliobackend.model.Usuario;

public interface IUsuarioService {
    
    public List<Usuario> obtenerTodosLosUsuarios();
    public List<String> obtenerTodosLosNombreDeUsuariosConRolAdministrador();
    public Usuario buscarUsuarioPorNombreDeUsuario(String nombreDeUsuario);
    public Usuario buscarUsuarioPorID(int id);
    public Boolean existeElNombreDeUsuario(String nombreDeUsuario);
    public Boolean existeElEmail(String email);
    public Boolean existeLaClave(String clave);
    public Usuario guardar(Usuario usuario);
    public void eliminarUsuarioPorID(int id);
}
