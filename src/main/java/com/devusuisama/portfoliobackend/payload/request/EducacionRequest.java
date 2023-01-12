package com.devusuisama.portfoliobackend.payload.request;

import lombok.Getter;

@Getter
public class EducacionRequest {
    private String url;
    private String titulo;
    private String tituloDeLaCarrera;
    private String descripcion;
    private int estado;
    private String fechaInicio;
    private String fechaFinal;
}
