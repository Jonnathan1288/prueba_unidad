package com.edu.proyect.PruebaGT.repository;

import com.edu.proyect.PruebaGT.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, Integer> {
}
