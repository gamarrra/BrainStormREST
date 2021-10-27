package com.brainstorm.controller;

import com.brainstorm.exception.ResourceNotFoundException;
import com.brainstorm.model.SubTarea;
import com.brainstorm.repository.SubTareasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class SubTareaController {

    @Autowired
    SubTareasRepository subTareasRepository;

    @GetMapping("/subtareas")
    public List<SubTarea> getAll() {
        return subTareasRepository.findAll();
    }

    @PostMapping("/subtareas")
    public SubTarea create(@Valid @RequestBody SubTarea subTarea) {
        return subTareasRepository.save(subTarea);
    }

    @GetMapping("/subtareas/{id}")
    public SubTarea getById(@PathVariable(value = "id") Long subtareaId) {
        return subTareasRepository.findById(subtareaId)
                .orElseThrow(() -> new ResourceNotFoundException("SubTarea", "id", subtareaId));
    }

    @PutMapping("/subtareas/{id}")
    public SubTarea update(@PathVariable(value = "id") Long subTareaId,
                                           @Valid @RequestBody SubTarea subTareaDetails) {

    	SubTarea subTarea = subTareasRepository.findById(subTareaId)
                .orElseThrow(() -> new ResourceNotFoundException("SubTarea", "id", subTareaId));

    	subTarea.setDescripcion(subTareaDetails.getDescripcion());
    	subTarea.setUsuarioCreadorSubTarea(subTareaDetails.getUsuarioCreadorSubTarea());
    	subTarea.setUsuarioResponsableSubTarea(subTareaDetails.getUsuarioResponsableSubTarea());
    	subTarea.setTareaOrigen(subTareaDetails.getTareaOrigen());
    	subTarea.setPuntaje(subTareaDetails.getPuntaje());
    	subTarea.setPrioridad(subTareaDetails.getPrioridad());
    	subTarea.setIconoId(subTareaDetails.getIconoId());
    	subTarea.setFechaComprometida(subTareaDetails.getFechaComprometida());
    	subTarea.setEstadoSubtarea(subTareaDetails.getEstadoSubtarea());

        SubTarea tareaAcutalizada = subTareasRepository.save(subTarea);
        return tareaAcutalizada;
    }

    @DeleteMapping("/subtareas/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long subTareaId) {
    	SubTarea tarea = subTareasRepository.findById(subTareaId)
                .orElseThrow(() -> new ResourceNotFoundException("SubTarea", "id", subTareaId));

        subTareasRepository.delete(tarea);

        return ResponseEntity.ok().build();
    }
}
