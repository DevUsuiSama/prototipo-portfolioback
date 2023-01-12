package com.devusuisama.portfoliobackend.model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;
    @Length(max = 50)
    private String nombre;
    @Length(max = 50)
    private String apellido;
    @Length(max = 200)
    private String titulo;
    @Length(max = 200)
    private String ubicacion;
    @OneToOne(mappedBy = "detalle")
    private Portfolio portfolio;
}
