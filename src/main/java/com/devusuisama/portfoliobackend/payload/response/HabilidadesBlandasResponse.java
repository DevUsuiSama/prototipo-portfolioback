package com.devusuisama.portfoliobackend.payload.response;

import com.devusuisama.portfoliobackend.model.PortfolioHabilidadesBlandas;

import lombok.Getter;

@Getter
public class HabilidadesBlandasResponse {
    private int id;
    private String nombre;

    public HabilidadesBlandasResponse(PortfolioHabilidadesBlandas e) {
        this.id = e.getId();
        this.nombre = e.getHabilidadesBlandas().getNombre();
    }
}
