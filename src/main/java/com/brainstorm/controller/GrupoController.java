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
    public List<Grupo> getAll() {
        return grupoRepository.findAll();
    }

    @PostMapping("/grupos")
    public Grupo createNote(@Valid @RequestBody Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    @GetMapping("/grupos/{id}")
    public Grupo getById(@PathVariable(value = "id") Long grupoId) {
        return grupoRepository.findById(grupoId)
                .orElseThrow(() -> new ResourceNotFoundException("Grupo", "id", grupoId));
    }

    @PutMapping("/grupos/{id}")
    public Grupo update(@PathVariable(value = "id") Long grupoId,
                                           @Valid @RequestBody Grupo grupoDetails) {

    	Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", grupoId));

    	grupo.setNombre(grupoDetails.getNombre());
    	grupo.setUsuarioCreadorGrupo(grupoDetails.getUsuarioCreadorGrupo());
    	grupo.setListTareas(grupoDetails.getListTareas());
    	grupo.setIconoId(grupoDetails.getIconoId());
    	grupo.setDescripcion(grupoDetails.getDescripcion());
    	
    	Grupo grupoActualizado = grupoRepository.save(grupo);
        return grupoActualizado;
    }

    @DeleteMapping("/grupos/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long grupoId) {
    	Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new ResourceNotFoundException("Grupo", "id", grupoId));

        grupoRepository.delete(grupo);

        return ResponseEntity.ok().build();
    }
}
