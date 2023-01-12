package com.devusuisama.portfoliobackend.payload.response;

import java.util.Date;

import com.devusuisama.portfoliobackend.model.Experiencia;

import lombok.Getter;

@Getter
public class ExperienciaResponse {
    private int id;
    private String url;
    private String titulo;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFinal;

    public ExperienciaResponse(Experiencia exp) {
        this.id = exp.getId();
        this.url = exp.getUrl();
        this.titulo = exp.getTitulo();
        this.descripcion = exp.getDescripcion();
        this.fechaInicio = exp.getFechaInicio();
        this.fechaFinal = exp.getFechaFinal();
    }
}
