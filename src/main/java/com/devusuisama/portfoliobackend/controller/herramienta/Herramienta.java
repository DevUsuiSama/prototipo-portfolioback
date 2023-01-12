package com.devusuisama.portfoliobackend.controller.herramienta;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.devusuisama.portfoliobackend.payload.response.EducacionResponse;
import com.devusuisama.portfoliobackend.payload.response.ExperienciaResponse;
import com.devusuisama.portfoliobackend.payload.response.ProyectoResponse;

public class Herramienta {
    /*
     * Organizar Lista Experiencia
     */
    public static <T extends ExperienciaResponse> void organizarListaExp(List<T> list) {
        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return (o1.getId() < o2.getId() ? -1 : 0);
            }
        });
    }

    /*
     * Organizar Lista Educación
     */
    public static <T extends EducacionResponse> void organizarListaEdu(List<T> list) {
        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return (o1.getId() < o2.getId() ? -1 : 0);
            }
        });
    }

     /*
     * Organizar Lista Proyecto
     */
    public static <T extends ProyectoResponse> void organizarListaPro(List<T> list) {
        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return (o1.getId() < o2.getId() ? -1 : 0);
            }
        });
    }
}
