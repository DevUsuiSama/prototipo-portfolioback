package com.devusuisama.portfoliobackend.service.interfaces;

import com.devusuisama.portfoliobackend.model.EPerfil;
import com.devusuisama.portfoliobackend.model.Perfil;

public interface IPerfilService {
    
    Perfil buscarPorRol(EPerfil ePerfil);

}
