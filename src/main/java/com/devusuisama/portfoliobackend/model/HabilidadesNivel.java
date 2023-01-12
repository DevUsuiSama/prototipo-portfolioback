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

@Getter
@Setter
@Entity
public class HabilidadesNivel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;
    
    @Length(max = 10)
    private String nombre;

    @OneToMany(mappedBy = "habilidadesNivel")
    private List<PortfolioHabilidadesDuras> portfolioHabilidadesDuras = new ArrayList<>();
}
