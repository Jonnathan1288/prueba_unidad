package com.edu.proyect.PruebaGT.repository;

import com.edu.proyect.PruebaGT.model.ListaReproduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaReproduccionRepository extends JpaRepository<ListaReproduccion, Integer> {
}
