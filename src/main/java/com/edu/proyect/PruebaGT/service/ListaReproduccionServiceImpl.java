package com.edu.proyect.PruebaGT.service;

import com.edu.proyect.PruebaGT.model.ListaReproduccion;
import com.edu.proyect.PruebaGT.repository.ListaReproduccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ListaReproduccionServiceImpl extends GenericServiceImpl<ListaReproduccion, Integer> implements ListaReproduccionService{
    @Autowired
    private ListaReproduccionRepository listaReproduccionRepository;

    @Override
    public CrudRepository<ListaReproduccion, Integer> getDao() {
        return listaReproduccionRepository;
    }
}
