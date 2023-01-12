package com.devusuisama.portfoliobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.devusuisama.portfoliobackend.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByNombreDeUsuario(String nombreDeUsuario);
    Boolean existsByNombreDeUsuario(String nombreDeUsuario);
    Boolean existsByEmail(String email);
    Boolean existsByClave(String clave);

}
