package com.devusuisama.portfoliobackend.payload.response;

import com.devusuisama.portfoliobackend.model.PortfolioHabilidadesDuras;

import lombok.Getter;

@Getter
public class HabilidadesNivelReponse {
    private int id;
    private String nombre;

    public HabilidadesNivelReponse(PortfolioHabilidadesDuras e) {
        this.id = e.getHabilidadesDuras().getId();
        this.nombre = e.getHabilidadesNivel().getNombre();
    }
}
