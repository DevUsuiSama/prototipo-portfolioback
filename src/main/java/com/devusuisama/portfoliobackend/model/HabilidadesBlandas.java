package com.devusuisama.portfoliobackend.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class HabilidadesBlandas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Length(max = 30)
    private String nombre;

    @OneToMany(mappedBy = "habilidadesBlandas")
    private List<PortfolioHabilidadesBlandas> portfolioHabilidadesBlandas = new ArrayList<>();
}
