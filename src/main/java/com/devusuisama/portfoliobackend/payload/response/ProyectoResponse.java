package com.devusuisama.portfoliobackend.payload.response;

import com.devusuisama.portfoliobackend.model.Proyecto;

import lombok.Getter;

@Getter
public class ProyectoResponse {
    private int id;
    private String titulo;
    private String descripcion;
    private String imagen;
    private String repositorio;

    public ProyectoResponse(Proyecto proyecto) {
        this.id = proyecto.getId();
        this.titulo = proyecto.getTitulo();
        this.descripcion = proyecto.getDescripcion();
        this.imagen = proyecto.getImagen();
        this.repositorio = proyecto.getRepositorio();
    }
}
