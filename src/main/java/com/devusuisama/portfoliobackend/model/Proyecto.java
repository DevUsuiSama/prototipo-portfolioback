package com.devusuisama.portfoliobackend.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;
    
    @Length(max = 50)
    @NotNull
    private String titulo;
    
    @Length(max = 200)
    @NotNull
    private String descripcion;

    @Length(max = 300)
    @NotNull
    private String imagen;

    @Length(max = 300)
    @NotNull
    private String repositorio;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_portfolio")
    @NotNull
    private Portfolio portfolio;
}
