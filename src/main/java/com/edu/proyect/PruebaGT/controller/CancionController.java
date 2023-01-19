package com.edu.proyect.PruebaGT.controller;

import com.edu.proyect.PruebaGT.model.Cancion;
import com.edu.proyect.PruebaGT.model.ListaReproduccion;
import com.edu.proyect.PruebaGT.service.CancionService;
import com.edu.proyect.PruebaGT.service.ListaReproduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class CancionController {
    @Autowired
    private CancionService cancionService;

    @GetMapping("/cancion/listar")
    public ResponseEntity<List<Cancion>> getAll() {
        try {
            return new ResponseEntity<>(cancionService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/cancion/search/{id}")
    public ResponseEntity<Cancion> getById(@PathVariable("id") Integer id){
        try {
            return  new ResponseEntity<>(cancionService.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/cancion/crear")
    public ResponseEntity<Cancion> createReproducion(@RequestBody Cancion cancion){
        try {
            return new ResponseEntity<>(cancionService.save(cancion), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/cancion/delete/{id}")
    public ResponseEntity<?> deletesong(@PathVariable("id") Integer id) {
        try {
            cancionService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar al cancion por que el ya esta en otra entidad realacinada");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/cancion/update/{id}")
    public ResponseEntity<Cancion> updateClient(@RequestBody Cancion cancion, @PathVariable("id") Integer id){
        Cancion canUp = cancionService.findById(id);

        if(canUp == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                canUp.setAlbum(cancion.getAlbum());
                canUp.setArtist(cancion.getArtist());
                canUp.setTitle(cancion.getTitle());
                canUp.setYear(cancion.getYear());
                return new ResponseEntity<>(cancionService.save(cancion), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
