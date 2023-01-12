package com.devusuisama.portfoliobackend.payload.response;

import java.util.ArrayList;
import java.util.List;

import com.devusuisama.portfoliobackend.model.EPerfil;
import com.devusuisama.portfoliobackend.model.Usuario;

import lombok.Getter;

@Getter
public class UsuariosResponse {
    private int id;
    private String nombreDeUsuario;
    private String email;
    private String clave;
    private List<EPerfil> perfil = new ArrayList<>();

    public UsuariosResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.nombreDeUsuario = usuario.getNombreDeUsuario();
        this.email = usuario.getEmail();
        this.clave = usuario.getClave();
        usuario.getPerfiles().forEach((e) -> {
            this.perfil.add(e.getRol());
        });
    }
}
