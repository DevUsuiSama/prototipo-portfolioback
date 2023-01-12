package com.devusuisama.portfoliobackend.payload.request;

import lombok.Getter;

@Getter
public class ProyectoRequest {
    private String titulo;
    private String descripcion;
    private String imagen;
    private String repositorio;
}
