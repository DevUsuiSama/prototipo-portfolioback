package com.devusuisama.portfoliobackend.payload.request;

import lombok.Getter;

@Getter
public class ExperienciaRequest {
    private String url;
    private String titulo;
    private String descripcion;
    private String fechaInicio;
    private String fechaFinal;
}
