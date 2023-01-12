package com.devusuisama.portfoliobackend.payload.response;

import com.devusuisama.portfoliobackend.model.PortfolioHabilidadesDuras;

import lombok.Getter;

@Getter
public class HabilidadesDurasResponse {
    private int id;
    private String nombre;
    private String imagen;
    private String sitioweb;

    public HabilidadesDurasResponse(PortfolioHabilidadesDuras e) {
        this.id = e.getId();
        this.nombre = e.getHabilidadesDuras().getNombre();
        this.imagen = e.getHabilidadesDuras().getImagen();
        this.sitioweb = e.getHabilidadesDuras().getSitioweb();
    }
}
