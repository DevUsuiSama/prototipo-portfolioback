package com.devusuisama.portfoliobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devusuisama.portfoliobackend.model.HabilidadesBlandas;

@Repository
public interface HabilidadesBlandasRepository extends JpaRepository<HabilidadesBlandas, Integer> {
    
}
