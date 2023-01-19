package com.edu.proyect.PruebaGT.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name ="listareproducciones")
public class ListaReproduccion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reproduccion")
    private Integer id_reproduccion;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cancion", referencedColumnName = "id_cancion")
    private Cancion cancion;
}
