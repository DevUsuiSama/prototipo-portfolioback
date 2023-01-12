package com.devusuisama.portfoliobackend.payload.response;

import com.devusuisama.portfoliobackend.model.Detalle;

import lombok.Getter;

@Getter
public class DetailResponse {
    private String nombre;
    private String apellido;
    private String titulo;
    private String ubicacion;

    public DetailResponse(Detalle detalle) {
        this.nombre = detalle.getNombre();
        this.apellido = detalle.getApellido();
        this.titulo = detalle.getTitulo();
        this.ubicacion = detalle.getUbicacion();
    }
}