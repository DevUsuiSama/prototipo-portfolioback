package com.devusuisama.portfoliobackend.payload.request;

import lombok.Getter;

@Getter
public class DetailRequest {
    private String username;
    private String nombre;
    private String apellido;
    private String titulo;
    private String ubicacion;
}
