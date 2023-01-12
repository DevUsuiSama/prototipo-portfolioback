package com.devusuisama.portfoliobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devusuisama.portfoliobackend.model.HabilidadesNivel;

@Repository
public interface HabilidadesNivelRepository extends JpaRepository<HabilidadesNivel, Integer> {
    
}
