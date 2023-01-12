package com.devusuisama.portfoliobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devusuisama.portfoliobackend.model.HabilidadesDuras;

@Repository
public interface HabilidadesDurasRepository extends JpaRepository<HabilidadesDuras, Integer> {
    
}
