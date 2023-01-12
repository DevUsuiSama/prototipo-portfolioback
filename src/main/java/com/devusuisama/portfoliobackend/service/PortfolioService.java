package com.devusuisama.portfoliobackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.devusuisama.portfoliobackend.repository.AcercaDeRepository;
import com.devusuisama.portfoliobackend.repository.DetalleRepository;
import com.devusuisama.portfoliobackend.repository.EducacionRepository;
import com.devusuisama.portfoliobackend.repository.ExperienciaRepository;
import com.devusuisama.portfoliobackend.repository.HabilidadesBlandasRepository;
import com.devusuisama.portfoliobackend.repository.HabilidadesDurasRepository;
import com.devusuisama.portfoliobackend.repository.HabilidadesNivelRepository;
import com.devusuisama.portfoliobackend.repository.PortfolioHabilidadesBlandasRepository;
import com.devusuisama.portfoliobackend.repository.PortfolioHabilidadesDurasRepository;
import com.devusuisama.portfoliobackend.repository.PortfolioRepository;
import com.devusuisama.portfoliobackend.repository.ProyectoRepository;
import com.devusuisama.portfoliobackend.service.interfaces.IPortfolioService;

@Service
public class PortfolioService implements IPortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;
    @Autowired
    private DetalleRepository detalleRepository;
    @Autowired
    private AcercaDeRepository acercaDeRepository;
    @Autowired
    private ExperienciaRepository experienciaRepository;
    @Autowired
    private EducacionRepository educacionRepository;
    @Autowired
    private HabilidadesDurasRepository habilidadesDurasRepository;
    @Autowired
    private HabilidadesNivelRepository habilidadesNivelRepository;
    @Autowired
    private PortfolioHabilidadesDurasRepository portfolioHabilidadesDurasRepository;
    @Autowired
    private HabilidadesBlandasRepository habilidadesBlandasRepository;
    @Autowired
    private PortfolioHabilidadesBlandasRepository portfolioHabilidadesBlandasRepository;
    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public Portfolio guardar(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    @Override
    public void eliminarPorID(int id) {
        portfolioRepository.deleteById(id);
    }

    @Override
    public Detalle guardarDetalle(Detalle detalle) {
        return detalleRepository.save(detalle);
    }

    @Override
    public void eliminarDetallePorID(int id) {
        detalleRepository.deleteById(id);
    }

    @Override
    public AcercaDe guardarAcercaDe(AcercaDe acercaDe) {
        return acercaDeRepository.save(acercaDe);
    }

    @Override
    public void eliminarAcercaDePorID(int id) {
        acercaDeRepository.deleteById(id);
    }

    // ___________                           .__                            
    // \_   _____/__  _________   ___________|__| ____   ____   ____  ____  
    //  |    __)_\  \/  /\____ \_/ __ \_  __ \  |/ __ \ /    \_/ ___\/ __ \ 
    //  |        \>    < |  |_> >  ___/|  | \/  \  ___/|   |  \  \__\  ___/ 
    // /_______  /__/\_ \|   __/ \___  >__|  |__|\___  >___|  /\___  >___  >
    //         \/      \/|__|        \/              \/     \/     \/    \/ 
    @Override
    public Experiencia guardarExperiencia(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    @Override
    public Experiencia buscarExperienciaPorID(int id) {
        return experienciaRepository.findById(id).orElseThrow();
    }

    @Override
    public void eliminarExperienciaPorID(int id) {
        experienciaRepository.deleteById(id);
    }
    
    // ___________    .___                    __  .__               
    // \_   _____/  __| _/_ __   ____ _____ _/  |_|__| ____   ____  
    //  |    __)_  / __ |  |  \_/ ___\\__  \\   __\  |/  _ \ /    \ 
    //  |        \/ /_/ |  |  /\  \___ / __ \|  | |  (  <_> )   |  \
    // /_______  /\____ |____/  \___  >____  /__| |__|\____/|___|  /
    //         \/      \/           \/     \/                    \/ 
    @Override
    public Educacion guardarEducacion(Educacion educacion) {
        return educacionRepository.save(educacion);
    }

    @Override
    public Educacion buscarEducacionPorID(int id) {
        return educacionRepository.findById(id).orElseThrow();
    }

    @Override
    public void eliminarEducacionPorID(int id) {
        educacionRepository.deleteById(id);
    }

    //   ___ ___                  .______________   .__.__  .__          
    //   /   |   \_____ _______  __| _/   _____/  | _|__|  | |  |   ______
    //  /    ~    \__  \\_  __ \/ __ |\_____  \|  |/ /  |  | |  |  /  ___/
    //  \    Y    // __ \|  | \/ /_/ |/        \    <|  |  |_|  |__\___ \ 
    //   \___|_  /(____  /__|  \____ /_______  /__|_ \__|____/____/____  >
    //         \/      \/           \/       \/     \/                 \/ 
    @Override
    public PortfolioHabilidadesDuras guardarHabilidadesDuras(PortfolioHabilidadesDuras portfolioHabilidadesDuras) {
        return portfolioHabilidadesDurasRepository.save(portfolioHabilidadesDuras);
    }

    @Override
    public PortfolioHabilidadesDuras buscarPortfolioHabilidadesDuras(int id) {
        return portfolioHabilidadesDurasRepository.findById(id).orElseThrow();
    }

    @Override
    public void eliminarPortfolioHabilidadesDuras(int id) {
        portfolioHabilidadesDurasRepository.deleteById(id);
    }
    
    @Override
    public HabilidadesDuras buscarHabilidadesDurasPorID(int id) {
        return habilidadesDurasRepository.findById(id).orElseThrow();
    }

    // .____                      .__    ___________   .__.__  .__          
    // |    |    _______  __ ____ |  |  /   _____/  | _|__|  | |  |   ______
    // |    |  _/ __ \  \/ // __ \|  |  \_____  \|  |/ /  |  | |  |  /  ___/
    // |    |__\  ___/\   /\  ___/|  |__/        \    <|  |  |_|  |__\___ \ 
    // |_______ \___  >\_/  \___  >____/_______  /__|_ \__|____/____/____  >
    //         \/   \/          \/             \/     \/                 \/ 
    @Override
    public HabilidadesNivel buscarHabilidadesNivelPorID(int id) {
        return habilidadesNivelRepository.findById(id).orElseThrow();
    }

    //   _________       _____  __   ___________   .__.__  .__          
    //   /   _____/ _____/ ____\/  |_/   _____/  | _|__|  | |  |   ______
    //   \_____  \ /  _ \   __\\   __\_____  \|  |/ /  |  | |  |  /  ___/
    //   /        (  <_> )  |   |  | /        \    <|  |  |_|  |__\___ \ 
    //  /_______  /\____/|__|   |__|/_______  /__|_ \__|____/____/____  >
    //          \/                          \/     \/                 \/ 
    @Override
    public PortfolioHabilidadesBlandas guardarHabilidadesBlandas(PortfolioHabilidadesBlandas portfolioHabilidadesBlandas) {
        return portfolioHabilidadesBlandasRepository.save(portfolioHabilidadesBlandas);
    }

    @Override
    public PortfolioHabilidadesBlandas buscarPortfolioHabilidadesBlandas(int id) {
        return portfolioHabilidadesBlandasRepository.findById(id).orElseThrow();
    }

    @Override
    public void eliminarPortfolioHabilidadesBlandas(int id) {
        portfolioHabilidadesBlandasRepository.deleteById(id);
    }

    @Override
    public HabilidadesBlandas buscarHabilidadesBlandasPorID(int id) {
        return habilidadesBlandasRepository.findById(id).orElseThrow();
    }

     // __________                   __               __   
    // \______   \_______  ____    |__| ____   _____/  |_ 
    //  |     ___/\_  __ \/  _ \   |  |/ __ \_/ ___\   __\
    //  |    |     |  | \(  <_> )  |  \  ___/\  \___|  |  
    //  |____|     |__|   \____/\__|  |\___  >\___  >__|  
    //                         \______|    \/     \/      
    @Override
    public Proyecto guardarProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    @Override
    public Proyecto buscarProyectoPorID(int id) {
        return proyectoRepository.findById(id).orElseThrow();
    }

    @Override
    public void eliminarProyectoPorID(int id) {
        proyectoRepository.deleteById(id);
    }
}