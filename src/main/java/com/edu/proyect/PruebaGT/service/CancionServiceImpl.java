package com.edu.proyect.PruebaGT.service;

import com.edu.proyect.PruebaGT.model.Cancion;
import com.edu.proyect.PruebaGT.repository.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CancionServiceImpl extends GenericServiceImpl<Cancion, Integer> implements CancionService{
    @Autowired
    private CancionRepository cancionRepository;

    @Override
    public CrudRepository<Cancion, Integer> getDao() {
        return cancionRepository;
    }
}
