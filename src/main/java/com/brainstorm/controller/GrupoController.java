package com.brainstorm.controller;

import com.brainstorm.exception.ResourceNotFoundException;
import com.brainstorm.model.Grupo;
import com.brainstorm.repository.GrupoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class GrupoController {

	
    @Autowired
    GrupoRepository grupoRepository;

    @GetMapping("/grupos")
    public List<Grupo> getAllGrupos() {
        return grupoRepository.findAll();
    }

    @PostMapping("/grupos")
    public Grupo createNote(@Valid @RequestBody Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    @GetMapping("/grupos/{id}")
    public Grupo getNoteById(@PathVariable(value = "id") Long grupoId) {
        return grupoRepository.findById(grupoId)
                .orElseThrow(() -> new ResourceNotFoundException("Grupo", "id", grupoId));
    }

    @PutMapping("/grupos/{id}")
    public Grupo updateNote(@PathVariable(value = "id") Long grupoId,
                                           @Valid @RequestBody Grupo grupoDetails) {

    	Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", grupoId));

    	grupo.setCreadorId(grupoDetails.getCreadorId());
    	grupo.setTareaId(grupoDetails.getTareaId());
    	grupo.setNombre(grupoDetails.getNombre());
    	grupo.setIconoId(grupoDetails.getIconoId());

    	Grupo grupoActualizado = grupoRepository.save(grupo);
        return grupoActualizado;
    }

    @DeleteMapping("/grupos/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long grupoId) {
    	Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new ResourceNotFoundException("Grupo", "id", grupoId));

        grupoRepository.delete(grupo);

        return ResponseEntity.ok().build();
    }
}
