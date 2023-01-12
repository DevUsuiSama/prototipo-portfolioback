package com.devusuisama.portfoliobackend.payload.response;

import java.util.Date;

import com.devusuisama.portfoliobackend.model.Educacion;

import lombok.Getter;

@Getter
public class EducacionResponse {
    private int id;
    private String url;
    private String titulo;
    private String tituloDeLaCarrera;
    private String descripcion;
    private int estado;
    private Date fechaInicio;
    private Date fechaFinal;

    public EducacionResponse(Educacion educacion) {
        this.id = educacion.getId();
        this.url = educacion.getUrl();
        this.titulo = educacion.getTitulo();
        this.tituloDeLaCarrera = educacion.getTituloDeLaCarrera();
        this.descripcion = educacion.getDescripcion();
        this.estado = educacion.getEstado();
        this.fechaInicio = educacion.getFechaInicio();
        this.fechaFinal = educacion.getFechaFinal();
    }
}
