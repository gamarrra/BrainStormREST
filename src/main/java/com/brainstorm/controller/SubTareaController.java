package com.brainstorm.controller;

import com.brainstorm.exception.ResourceNotFoundException;
import com.brainstorm.model.SubTarea;
import com.brainstorm.model.Tarea;
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
    public List<SubTarea> getAllSubTareas() {
        return subTareasRepository.findAll();
    }

    @PostMapping("/subtareas")
    public SubTarea createNote(@Valid @RequestBody SubTarea subTarea) {
        return subTareasRepository.save(subTarea);
    }

    @GetMapping("/subtareas/{id}")
    public SubTarea getNoteById(@PathVariable(value = "id") Long subtareaId) {
        return subTareasRepository.findById(subtareaId)
                .orElseThrow(() -> new ResourceNotFoundException("SubTarea", "id", subtareaId));
    }

    @PutMapping("/subtareas/{id}")
    public SubTarea updateNote(@PathVariable(value = "id") Long subTareaId,
                                           @Valid @RequestBody SubTarea tareaDetails) {

    	SubTarea subTarea = subTareasRepository.findById(subTareaId)
                .orElseThrow(() -> new ResourceNotFoundException("SubTarea", "id", subTareaId));

    	subTarea.setDescripcion(tareaDetails.getDescripcion());
    	subTarea.setResponsable(tareaDetails.getResponsable());
    	subTarea.setStatusId(tareaDetails.getStatusId());
    	subTarea.setFechaComprometida(tareaDetails.getFechaComprometida());
    	subTarea.setPuntaje(tareaDetails.getPuntaje());
    	subTarea.setPrioridad(tareaDetails.getPrioridad());
    	subTarea.setIconoId(tareaDetails.getIconoId());
    	subTarea.setTareaId(tareaDetails.getTareaId());

        SubTarea tareaAcutalizada = subTareasRepository.save(subTarea);
        return tareaAcutalizada;
    }

    @DeleteMapping("/subtareas/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long subTareaId) {
    	SubTarea tarea = subTareasRepository.findById(subTareaId)
                .orElseThrow(() -> new ResourceNotFoundException("SubTarea", "id", subTareaId));

        subTareasRepository.delete(tarea);

        return ResponseEntity.ok().build();
    }
}
