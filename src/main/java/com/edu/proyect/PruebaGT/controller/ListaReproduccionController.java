package com.edu.proyect.PruebaGT.controller;

import com.edu.proyect.PruebaGT.model.ListaReproduccion;
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
public class ListaReproduccionController {

    @Autowired
    private ListaReproduccionService listaReproduccionService;

    @GetMapping("/listcancion/listar")
    public ResponseEntity<List<ListaReproduccion>> getAll() {
        try {
            return new ResponseEntity<>(listaReproduccionService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/listcancion/search/{id}")
    public ResponseEntity<ListaReproduccion> getById(@PathVariable("id") Integer id){
        try {
            return  new ResponseEntity<>(listaReproduccionService.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/listcancion/crear")
    public ResponseEntity<ListaReproduccion> createReproducion(@RequestBody ListaReproduccion listaReproduccion){
        try {
            return new ResponseEntity<>(listaReproduccionService.save(listaReproduccion), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/listcancion/delete/{id}")
    public ResponseEntity<?> deleteReproduction(@PathVariable("id") Integer id) {
        try {
            listaReproduccionService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar al lista por que el ya esta en otra entidad realacinada");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/listcancion/update/{id}")
    public ResponseEntity<ListaReproduccion> updateClient(@RequestBody ListaReproduccion listaReproduccion, @PathVariable("id") Integer id){
        ListaReproduccion listarUp = listaReproduccionService.findById(id);

        if(listarUp == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {

                listarUp.setName(listaReproduccion.getName());
                listarUp.setDescription(listaReproduccion.getDescription());
                listarUp.setCancion(listaReproduccion.getCancion());
                return new ResponseEntity<>(listaReproduccionService.save(listarUp), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
