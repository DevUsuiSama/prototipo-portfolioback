package com.devusuisama.portfoliobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devusuisama.portfoliobackend.model.PortfolioHabilidadesDuras;

@Repository
public interface PortfolioHabilidadesDurasRepository extends JpaRepository<PortfolioHabilidadesDuras, Integer> {
    
}
