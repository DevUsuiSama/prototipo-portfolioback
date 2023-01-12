package com.devusuisama.portfoliobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devusuisama.portfoliobackend.model.AcercaDe;

@Repository
public interface AcercaDeRepository extends JpaRepository<AcercaDe, Integer> {
    
}
