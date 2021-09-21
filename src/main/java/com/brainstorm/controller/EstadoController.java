package com.brainstorm.controller;

import com.brainstorm.exception.ResourceNotFoundException;
import com.brainstorm.model.Estado;
import com.brainstorm.model.Tarea;
import com.brainstorm.repository.EstadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class EstadoController {

    @Autowired
    EstadoRepository estadosRepository;

    @GetMapping("/estados")
    public List<Estado> getAll() {
        return estadosRepository.findAll();
    }

    @PostMapping("/estados")
    public Estado create(@Valid @RequestBody Estado estado) {
        return estadosRepository.save(estado);
    }

    @GetMapping("/estados/{id}")
    public Estado getById(@PathVariable(value = "id") Long estadoId) {
        return estadosRepository.findById(estadoId)
                .orElseThrow(() -> new ResourceNotFoundException("Estado", "id", estadoId));
    }

    @PutMapping("/estados/{id}")
    public Estado update(@PathVariable(value = "id") Long estadoId,
                                           @Valid @RequestBody Tarea tareaDetails) {

    	Estado estado = estadosRepository.findById(estadoId)
                .orElseThrow(() -> new ResourceNotFoundException("Estado", "id", estadoId));

    	estado.setDescripcion(tareaDetails.getDescripcion());

        Estado estadoActualizado = estadosRepository.save(estado);
        return estadoActualizado;
    }

    @DeleteMapping("/estados/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long estadoId) {
    	Estado tarea = estadosRepository.findById(estadoId)
                .orElseThrow(() -> new ResourceNotFoundException("Estado", "id", estadoId));

        estadosRepository.delete(tarea);

        return ResponseEntity.ok().build();
    }
}
