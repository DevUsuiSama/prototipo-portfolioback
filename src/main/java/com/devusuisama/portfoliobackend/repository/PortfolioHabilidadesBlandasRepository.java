package com.devusuisama.portfoliobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devusuisama.portfoliobackend.model.PortfolioHabilidadesBlandas;

@Repository
public interface PortfolioHabilidadesBlandasRepository extends JpaRepository<PortfolioHabilidadesBlandas, Integer> {
    
}
