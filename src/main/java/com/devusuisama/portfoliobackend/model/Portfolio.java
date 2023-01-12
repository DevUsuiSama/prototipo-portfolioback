package com.devusuisama.portfoliobackend.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;
    
    @Length(max = 300)
    private String urlBanner;
    
    @Length(max = 300)
    private String urlProfilePicture;
    
    @OneToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_detalle")
    private Detalle detalle;
    
    @OneToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_acerca_de")
    private AcercaDe acercaDe;
    
    @OneToMany(mappedBy = "portfolio")
    private Set<Experiencia> experiencia = new HashSet<>();
    
    @OneToMany(mappedBy = "portfolio")
    private Set<Educacion> educacion = new HashSet<>();

    @OneToMany(mappedBy = "portfolio")
    private Set<Proyecto> proyecto = new HashSet<>();
    
    @OneToOne(mappedBy = "portfolio")
    private Usuario usuario;

    @OneToMany(mappedBy = "portfolio")
    private List<PortfolioHabilidadesDuras> portfolioHabilidadesDuras = new ArrayList<>();

    @OneToMany(mappedBy = "portfolio")
    private List<PortfolioHabilidadesBlandas> portfolioHabilidadesBlandas = new ArrayList<>();
}
