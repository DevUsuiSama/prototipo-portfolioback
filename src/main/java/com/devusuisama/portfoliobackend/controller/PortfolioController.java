package com.devusuisama.portfoliobackend.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devusuisama.portfoliobackend.controller.herramienta.Herramienta;
import com.devusuisama.portfoliobackend.model.AcercaDe;
import com.devusuisama.portfoliobackend.model.Detalle;
import com.devusuisama.portfoliobackend.model.Educacion;
import com.devusuisama.portfoliobackend.model.Experiencia;
import com.devusuisama.portfoliobackend.model.Portfolio;
import com.devusuisama.portfoliobackend.model.PortfolioHabilidadesBlandas;
import com.devusuisama.portfoliobackend.model.PortfolioHabilidadesDuras;
import com.devusuisama.portfoliobackend.model.Proyecto;
import com.devusuisama.portfoliobackend.payload.response.PortfolioResponse;
import com.devusuisama.portfoliobackend.payload.response.ProyectoResponse;
import com.devusuisama.portfoliobackend.payload.request.DetailRequest;
import com.devusuisama.portfoliobackend.payload.request.EducacionRequest;
import com.devusuisama.portfoliobackend.payload.request.ExperienciaRequest;
import com.devusuisama.portfoliobackend.payload.request.ProyectoRequest;
import com.devusuisama.portfoliobackend.payload.response.DetailResponse;
import com.devusuisama.portfoliobackend.payload.response.EducacionResponse;
import com.devusuisama.portfoliobackend.payload.response.ExperienciaResponse;
import com.devusuisama.portfoliobackend.payload.response.HabilidadesBlandasResponse;
import com.devusuisama.portfoliobackend.payload.response.HabilidadesDurasResponse;
import com.devusuisama.portfoliobackend.payload.response.HabilidadesNivelReponse;
import com.devusuisama.portfoliobackend.payload.response.MessageResponse;
import com.devusuisama.portfoliobackend.service.interfaces.IPortfolioService;
import com.devusuisama.portfoliobackend.service.interfaces.IUsuarioService;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    @Autowired
    private IUsuarioService iUsuarioService;

    @Autowired
    private IPortfolioService iPortfolioService;

    // __________                                    
    // \______   \_____    ____   ____   ___________ 
    //  |    |  _/\__  \  /    \ /    \_/ __ \_  __ \
    //  |    |   \ / __ \|   |  \   |  \  ___/|  | \/
    //  |______  /(____  /___|  /___|  /\___  >__|   
    //         \/      \/     \/     \/     \/       
    @PostMapping("/banner/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> saveBanner(@RequestParam String username, @RequestParam String url) {
        Portfolio portfolio = iUsuarioService.buscarUsuarioPorNombreDeUsuario(username).getPortfolio();
        portfolio.setUrlBanner(url);
        iPortfolioService.guardar(portfolio);
        return ResponseEntity.ok(new MessageResponse("Banner saved successfully"));
    }

    @GetMapping("/banner/get_url/{username}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getBannerUrl(@PathVariable String username) {
        return ResponseEntity.ok(new PortfolioResponse(
                iUsuarioService.buscarUsuarioPorNombreDeUsuario(username).getPortfolio().getUrlBanner()));
    }

    // __________                _____.__.__           __________.__        __                        
    // \______   \_______  _____/ ____\__|  |   ____   \______   \__| _____/  |_ __ _________   ____  
    //  |     ___/\_  __ \/  _ \   __\|  |  | _/ __ \   |     ___/  |/ ___\   __\  |  \_  __ \_/ __ \ 
    //  |    |     |  | \(  <_> )  |  |  |  |_\  ___/   |    |   |  \  \___|  | |  |  /|  | \/\  ___/ 
    //  |____|     |__|   \____/|__|  |__|____/\___  >  |____|   |__|\___  >__| |____/ |__|    \___  >
    //                                             \/                    \/                        \/ 
    @PostMapping("/profile_picture/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> saveProfilePicture(@RequestParam String username, @RequestParam String url) {
        Portfolio portfolio = iUsuarioService.buscarUsuarioPorNombreDeUsuario(username).getPortfolio();
        portfolio.setUrlProfilePicture(url);
        iPortfolioService.guardar(portfolio);
        return ResponseEntity.ok(new MessageResponse("Profile Picture saved successfully"));
    }

    @GetMapping("/profile_picture/get_url/{username}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getPorfilePictureUrl(@PathVariable String username) {
        return ResponseEntity.ok(new PortfolioResponse(
                iUsuarioService.buscarUsuarioPorNombreDeUsuario(username).getPortfolio().getUrlProfilePicture()));
    }

    // ________          __         .__.__   
    // \______ \   _____/  |______  |__|  |  
    //  |    |  \_/ __ \   __\__  \ |  |  |  
    //  |    `   \  ___/|  |  / __ \|  |  |__
    // /_______  /\___  >__| (____  /__|____/
    //         \/     \/          \/         
    @PostMapping("/detail/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> saveDetail(@RequestBody DetailRequest detailRequest) {
        Portfolio portfolio = iUsuarioService.buscarUsuarioPorNombreDeUsuario(detailRequest.getUsername()).getPortfolio();
        Detalle detalle = portfolio.getDetalle();
        detalle.setNombre(detailRequest.getNombre());
        detalle.setApellido(detailRequest.getApellido());
        detalle.setTitulo(detailRequest.getTitulo());
        detalle.setUbicacion(detailRequest.getUbicacion());
        portfolio.setDetalle(iPortfolioService.guardarDetalle(detalle));
        iPortfolioService.guardar(portfolio);
        return ResponseEntity.ok(new MessageResponse("Detail saved successfully"));
    }
    
    @GetMapping("/detail/get_detail/{username}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getDetail(@PathVariable String username) {
        return ResponseEntity.ok(new DetailResponse(iUsuarioService.buscarUsuarioPorNombreDeUsuario(username).getPortfolio().getDetalle()));
    }

    //    _____ ___.                  __     _____          
    //    /  _  \\_ |__   ____  __ ___/  |_  /     \   ____  
    //   /  /_\  \| __ \ /  _ \|  |  \   __\/  \ /  \_/ __ \ 
    //  /    |    \ \_\ (  <_> )  |  /|  | /    Y    \  ___/ 
    //  \____|__  /___  /\____/|____/ |__| \____|__  /\___  >
    //          \/    \/                           \/     \/ 
    @PostMapping("/about_me/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> saveAboutMe(@RequestParam String username, @RequestParam String description) {
        Portfolio portfolio = iUsuarioService.buscarUsuarioPorNombreDeUsuario(username).getPortfolio();
        AcercaDe acercaDe = portfolio.getAcercaDe();
        acercaDe.setDescripcion(description);
        portfolio.setAcercaDe(iPortfolioService.guardarAcercaDe(acercaDe));
        iPortfolioService.guardar(portfolio);
        return ResponseEntity.ok(new MessageResponse("AboutMe saved successfully"));
    }
    
    @GetMapping("/about_me/get_description/{username}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getAboutMe(@PathVariable String username) {
        return ResponseEntity.ok(new PortfolioResponse(
                iUsuarioService.buscarUsuarioPorNombreDeUsuario(username).getPortfolio().getAcercaDe().getDescripcion()));
    }

    // ___________                           .__                            
    // \_   _____/__  _________   ___________|__| ____   ____   ____  ____  
    //  |    __)_\  \/  /\____ \_/ __ \_  __ \  |/ __ \ /    \_/ ___\/ __ \ 
    //  |        \>    < |  |_> >  ___/|  | \/  \  ___/|   |  \  \__\  ___/ 
    // /_______  /__/\_ \|   __/ \___  >__|  |__|\___  >___|  /\___  >___  >
    //         \/      \/|__|        \/              \/     \/     \/    \/ 
    @PostMapping("/experience/save/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> saveExperience(@PathVariable String username, @RequestBody ExperienciaRequest experienciaRequest) throws ParseException {
        Experiencia experiencia = new Experiencia();
        experiencia.setUrl(experienciaRequest.getUrl());
        experiencia.setTitulo(experienciaRequest.getTitulo());
        experiencia.setDescripcion(experienciaRequest.getDescripcion());
        experiencia.setFechaInicio(new SimpleDateFormat("yyyy-MM-dd").parse(experienciaRequest.getFechaInicio()));
        if (experienciaRequest.getFechaFinal().isEmpty())
            experiencia.setFechaFinal(null);
        else
            experiencia.setFechaFinal(new SimpleDateFormat("yyyy-MM-dd").parse(experienciaRequest.getFechaFinal()));
        experiencia.setPortfolio(iUsuarioService.buscarUsuarioPorNombreDeUsuario(username).getPortfolio());
        iPortfolioService.guardarExperiencia(experiencia);
        return ResponseEntity.ok(new MessageResponse("Experience saved successfully"));
    }

    @PutMapping("/experience/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateExperience(@PathVariable int id, @RequestBody ExperienciaRequest experienciaRequest) throws ParseException {
        Experiencia experiencia = iPortfolioService.buscarExperienciaPorID(id);
        experiencia.setUrl(experienciaRequest.getUrl());
        experiencia.setTitulo(experienciaRequest.getTitulo());
        experiencia.setDescripcion(experienciaRequest.getDescripcion());
        experiencia.setFechaInicio(new SimpleDateFormat("yyyy-MM-dd").parse(experienciaRequest.getFechaInicio()));
        if (experienciaRequest.getFechaFinal().isEmpty())
            experiencia.setFechaFinal(null);
        else
            experiencia.setFechaFinal(new SimpleDateFormat("yyyy-MM-dd").parse(experienciaRequest.getFechaFinal()));
        iPortfolioService.guardarExperiencia(experiencia);
        return ResponseEntity.ok(new MessageResponse("Experience update successfully"));
    }

    @DeleteMapping("/experience/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteExperience(@PathVariable int id) {
        iPortfolioService.eliminarExperienciaPorID(id);
        return ResponseEntity.ok(new MessageResponse("Experience delete successfully"));
    }
    
    @GetMapping("/experience/get_experience/{username}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getExperiencie(@PathVariable String username) {
        List<ExperienciaResponse> experienciaResponse = new ArrayList<>();
        iUsuarioService.buscarUsuarioPorNombreDeUsuario(username).getPortfolio().getExperiencia().forEach((e) -> {
            experienciaResponse.add(new ExperienciaResponse(e));
        });
        Herramienta.organizarListaExp(experienciaResponse);
        return ResponseEntity.ok(experienciaResponse);
    }

    // ___________    .___                    __  .__               
    // \_   _____/  __| _/_ __   ____ _____ _/  |_|__| ____   ____  
    //  |    __)_  / __ |  |  \_/ ___\\__  \\   __\  |/  _ \ /    \ 
    //  |        \/ /_/ |  |  /\  \___ / __ \|  | |  (  <_> )   |  \
    // /_______  /\____ |____/  \___  >____  /__| |__|\____/|___|  /
    //         \/      \/           \/     \/                    \/ 
    @PostMapping("/education/save/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> saveEducation(@PathVariable String username, @RequestBody EducacionRequest educacionRequest) throws ParseException {
        Educacion educacion = new Educacion();
        educacion.setUrl(educacionRequest.getUrl());
        educacion.setTitulo(educacionRequest.getTitulo());
        educacion.setTituloDeLaCarrera(educacionRequest.getTituloDeLaCarrera());
        educacion.setDescripcion(educacionRequest.getDescripcion());
        educacion.setEstado(educacionRequest.getEstado());
        educacion.setFechaInicio(new SimpleDateFormat("yyyy-MM-dd").parse(educacionRequest.getFechaInicio()));
        if (educacionRequest.getFechaFinal().isEmpty())
            educacion.setFechaFinal(null);
        else
            educacion.setFechaFinal(new SimpleDateFormat("yyyy-MM-dd").parse(educacionRequest.getFechaFinal()));
        educacion.setPortfolio(iUsuarioService.buscarUsuarioPorNombreDeUsuario(username).getPortfolio());
        iPortfolioService.guardarEducacion(educacion);
        return ResponseEntity.ok(new MessageResponse("Education saved successfully"));
    }

    @PutMapping("/education/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateEducation(@PathVariable int id, @RequestBody EducacionRequest educacionRequest) throws ParseException {
        Educacion educacion = iPortfolioService.buscarEducacionPorID(id);
        educacion.setUrl(educacionRequest.getUrl());
        educacion.setTitulo(educacionRequest.getTitulo());
        educacion.setTituloDeLaCarrera(educacionRequest.getTituloDeLaCarrera());
        educacion.setDescripcion(educacionRequest.getDescripcion());
        educacion.setEstado(educacionRequest.getEstado());
        educacion.setFechaInicio(new SimpleDateFormat("yyyy-MM-dd").parse(educacionRequest.getFechaInicio()));
        if (educacionRequest.getFechaFinal().isEmpty())
            educacion.setFechaFinal(null);
        else
            educacion.setFechaFinal(new SimpleDateFormat("yyyy-MM-dd").parse(educacionRequest.getFechaFinal()));
        iPortfolioService.guardarEducacion(educacion);
        return ResponseEntity.ok(new MessageResponse("Education update successfully"));
    }

    @DeleteMapping("/education/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteEducacion(@PathVariable int id) {
        iPortfolioService.eliminarEducacionPorID(id);
        return ResponseEntity.ok(new MessageResponse("Education delete successfully"));
    }
    
    @GetMapping("/education/get_education/{username}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getEducation(@PathVariable String username) {
        List<EducacionResponse> educacionResponse = new ArrayList<>();
        iUsuarioService.buscarUsuarioPorNombreDeUsuario(username).getPortfolio().getEducacion().forEach((e) -> {
            educacionResponse.add(new EducacionResponse(e));
        });
        Herramienta.organizarListaEdu(educacionResponse);
        return ResponseEntity.ok(educacionResponse);
    }

    //   ___ ___                  .______________   .__.__  .__          
    //   /   |   \_____ _______  __| _/   _____/  | _|__|  | |  |   ______
    //  /    ~    \__  \\_  __ \/ __ |\_____  \|  |/ /  |  | |  |  /  ___/
    //  \    Y    // __ \|  | \/ /_/ |/        \    <|  |  |_|  |__\___ \ 
    //   \___|_  /(____  /__|  \____ /_______  /__|_ \__|____/____/____  >
    //         \/      \/           \/       \/     \/                 \/ 
    @PostMapping("/hardskills/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> saveHardSkills(@RequestParam String username, @RequestParam int idPortfolioHabilidadesDuras, @RequestParam int idHardSkills, @RequestParam int idLevelSkills) {
        PortfolioHabilidadesDuras portfolioHabilidadesDuras = idPortfolioHabilidadesDuras == 0 ? new PortfolioHabilidadesDuras() : iPortfolioService.buscarPortfolioHabilidadesDuras(idPortfolioHabilidadesDuras);
        portfolioHabilidadesDuras.setPortfolio(iUsuarioService.buscarUsuarioPorNombreDeUsuario(username).getPortfolio());
        portfolioHabilidadesDuras.setHabilidadesDuras(iPortfolioService.buscarHabilidadesDurasPorID(idHardSkills));
        portfolioHabilidadesDuras.setHabilidadesNivel(iPortfolioService.buscarHabilidadesNivelPorID(idLevelSkills));
        iPortfolioService.guardarHabilidadesDuras(portfolioHabilidadesDuras);
        return ResponseEntity.ok(new MessageResponse("HardSkills saved successfully"));
    }

    @DeleteMapping("/hardskills/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteHardSkills(@PathVariable int id) {
        iPortfolioService.eliminarPortfolioHabilidadesDuras(id);
        return ResponseEntity.ok(new MessageResponse("HardSkills delete successfully"));
    }

    @GetMapping("/hardskills/get_hardskills/{username}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getHardSkills(@PathVariable String username) {
        List<HabilidadesDurasResponse> hDurasResponses = new ArrayList<>();
        iUsuarioService.buscarUsuarioPorNombreDeUsuario(username).getPortfolio().getPortfolioHabilidadesDuras().forEach((e) -> {
            hDurasResponses.add(new HabilidadesDurasResponse(e));
        });
        return ResponseEntity.ok(hDurasResponses);
    }

    // .____                      .__    ___________   .__.__  .__          
    // |    |    _______  __ ____ |  |  /   _____/  | _|__|  | |  |   ______
    // |    |  _/ __ \  \/ // __ \|  |  \_____  \|  |/ /  |  | |  |  /  ___/
    // |    |__\  ___/\   /\  ___/|  |__/        \    <|  |  |_|  |__\___ \ 
    // |_______ \___  >\_/  \___  >____/_______  /__|_ \__|____/____/____  >
    //         \/   \/          \/             \/     \/                 \/ 
    @GetMapping("/levelskills/get_levelskills/{username}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getLevelSkills(@PathVariable String username) {
        List<HabilidadesNivelReponse> hNivelReponses = new ArrayList<>();
        iUsuarioService.buscarUsuarioPorNombreDeUsuario(username).getPortfolio().getPortfolioHabilidadesDuras().forEach((e) -> {
            hNivelReponses.add(new HabilidadesNivelReponse(e));
        });
        return ResponseEntity.ok(hNivelReponses);
    }

    
    //   _________       _____  __   ___________   .__.__  .__          
    //   /   _____/ _____/ ____\/  |_/   _____/  | _|__|  | |  |   ______
    //   \_____  \ /  _ \   __\\   __\_____  \|  |/ /  |  | |  |  /  ___/
    //   /        (  <_> )  |   |  | /        \    <|  |  |_|  |__\___ \ 
    //  /_______  /\____/|__|   |__|/_______  /__|_ \__|____/____/____  >
    //          \/                          \/     \/                 \/ 
    @PostMapping("/softskills/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> saveSoftSkills(@RequestParam String username, @RequestParam int idPortfolioHabilidadesBlandas, @RequestParam int idSoftSkills) {
        PortfolioHabilidadesBlandas portfolioHabilidadesBlandas = idPortfolioHabilidadesBlandas == 0 ? new PortfolioHabilidadesBlandas() : iPortfolioService.buscarPortfolioHabilidadesBlandas(idPortfolioHabilidadesBlandas);
        portfolioHabilidadesBlandas.setPortfolio(iUsuarioService.buscarUsuarioPorNombreDeUsuario(username).getPortfolio());
        portfolioHabilidadesBlandas.setHabilidadesBlandas(iPortfolioService.buscarHabilidadesBlandasPorID(idSoftSkills));
        iPortfolioService.guardarHabilidadesBlandas(portfolioHabilidadesBlandas);
        return ResponseEntity.ok(new MessageResponse("SoftSkills saved successfully"));
    }

    @DeleteMapping("/softskills/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteSoftSkills(@PathVariable int id) {
        iPortfolioService.eliminarPortfolioHabilidadesBlandas(id);
        return ResponseEntity.ok(new MessageResponse("SoftSkills delete successfully"));
    }
    
    @GetMapping("/softskills/get_softskills/{username}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getSoftSkills(@PathVariable String username) {
        List<HabilidadesBlandasResponse> hBlandasResponses = new ArrayList<>();
        iUsuarioService.buscarUsuarioPorNombreDeUsuario(username).getPortfolio().getPortfolioHabilidadesBlandas().forEach((e) -> {
            hBlandasResponses.add(new HabilidadesBlandasResponse(e));
        });
        return ResponseEntity.ok(hBlandasResponses);
    }

    // __________                   __               __   
    // \______   \_______  ____    |__| ____   _____/  |_ 
    //  |     ___/\_  __ \/  _ \   |  |/ __ \_/ ___\   __\
    //  |    |     |  | \(  <_> )  |  \  ___/\  \___|  |  
    //  |____|     |__|   \____/\__|  |\___  >\___  >__|  
    //                         \______|    \/     \/      
    @PostMapping("/project/save/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> saveProject(@PathVariable String username, @RequestBody ProyectoRequest proyectoRequest) {
        Proyecto proyecto = new Proyecto();
        proyecto.setPortfolio(iUsuarioService.buscarUsuarioPorNombreDeUsuario(username).getPortfolio());
        proyecto.setTitulo(proyectoRequest.getTitulo());
        proyecto.setDescripcion(proyectoRequest.getDescripcion());
        proyecto.setImagen(proyectoRequest.getImagen());
        proyecto.setRepositorio(proyectoRequest.getRepositorio());
        iPortfolioService.guardarProyecto(proyecto);
        return ResponseEntity.ok(new MessageResponse("Project saved successfully"));
    }

    @PutMapping("/project/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateProject(@PathVariable int id, @RequestBody ProyectoRequest proyectoRequest) {
        Proyecto proyecto = iPortfolioService.buscarProyectoPorID(id);
        proyecto.setTitulo(proyectoRequest.getTitulo());
        proyecto.setDescripcion(proyectoRequest.getDescripcion());
        proyecto.setImagen(proyectoRequest.getImagen());
        proyecto.setRepositorio(proyectoRequest.getRepositorio());
        iPortfolioService.guardarProyecto(proyecto);
        return ResponseEntity.ok(new MessageResponse("Project update successfully"));
    }

    @DeleteMapping("/project/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteProject(@PathVariable int id) {
        iPortfolioService.eliminarProyectoPorID(id);
        return ResponseEntity.ok(new MessageResponse("Project delete successfully"));
    }

    @GetMapping("/project/get_project/{username}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getProject(@PathVariable String username) {
        List<ProyectoResponse> proyectoResponse = new ArrayList<>();
        iUsuarioService.buscarUsuarioPorNombreDeUsuario(username).getPortfolio().getProyecto().forEach((e) -> {
            proyectoResponse.add(new ProyectoResponse(e));
        });
        Herramienta.organizarListaPro(proyectoResponse);
        return ResponseEntity.ok(proyectoResponse);
    }
}