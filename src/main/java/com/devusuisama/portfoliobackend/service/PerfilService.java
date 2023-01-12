package com.devusuisama.portfoliobackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devusuisama.portfoliobackend.model.EPerfil;
import com.devusuisama.portfoliobackend.model.Perfil;
import com.devusuisama.portfoliobackend.repository.PerfilRepository;
import com.devusuisama.portfoliobackend.service.interfaces.IPerfilService;

@Service
public class PerfilService implements IPerfilService {

    @Autowired
    private PerfilRepository pRepository;

    @Override
    public Perfil buscarPorRol(EPerfil ePerfil) {
        Perfil perfil = pRepository.findByRol(ePerfil)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        return perfil;
    }

}
