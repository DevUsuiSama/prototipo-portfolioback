package com.devusuisama.portfoliobackend.service.interfaces;

import com.devusuisama.portfoliobackend.model.AcercaDe;
import com.devusuisama.portfoliobackend.model.Detalle;
import com.devusuisama.portfoliobackend.model.Educacion;
import com.devusuisama.portfoliobackend.model.Experiencia;
import com.devusuisama.portfoliobackend.model.HabilidadesBlandas;
import com.devusuisama.portfoliobackend.model.HabilidadesDuras;
import com.devusuisama.portfoliobackend.model.HabilidadesNivel;
import com.devusuisama.portfoliobackend.model.Portfolio;
import com.devusuisama.portfoliobackend.model.PortfolioHabilidadesBlandas;
import com.devusuisama.portfoliobackend.model.PortfolioHabilidadesDuras;
import com.devusuisama.portfoliobackend.model.Proyecto;

public interface IPortfolioService {   
    public Portfolio guardar(Portfolio portfolio);
    public void eliminarPorID(int id);
    public Detalle guardarDetalle(Detalle detalle);
    public void eliminarDetallePorID(int id);
    public AcercaDe guardarAcercaDe(AcercaDe acercaDe);
    public void eliminarAcercaDePorID(int id);
    public Experiencia guardarExperiencia(Experiencia experiencia);
    public Experiencia buscarExperienciaPorID(int id);
    public void eliminarExperienciaPorID(int id);
    public Educacion guardarEducacion(Educacion educacion);
    public Educacion buscarEducacionPorID(int id);
    public void eliminarEducacionPorID(int id);
    public PortfolioHabilidadesDuras guardarHabilidadesDuras(PortfolioHabilidadesDuras portfolioHabilidadesDuras);
    public PortfolioHabilidadesDuras buscarPortfolioHabilidadesDuras(int id);
    public void eliminarPortfolioHabilidadesDuras(int id);
    public HabilidadesDuras buscarHabilidadesDurasPorID(int id);
    public HabilidadesNivel buscarHabilidadesNivelPorID(int id);
    public PortfolioHabilidadesBlandas guardarHabilidadesBlandas(PortfolioHabilidadesBlandas portfolioHabilidadesBlandas);
    public PortfolioHabilidadesBlandas buscarPortfolioHabilidadesBlandas(int id);
    public void eliminarPortfolioHabilidadesBlandas(int id);
    public HabilidadesBlandas buscarHabilidadesBlandasPorID(int id);
    public Proyecto guardarProyecto(Proyecto proyecto);
    public Proyecto buscarProyectoPorID(int id);
    public void eliminarProyectoPorID(int id);
}
