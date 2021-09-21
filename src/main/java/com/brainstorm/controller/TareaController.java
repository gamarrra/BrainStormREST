package com.brainstorm.controller;

import com.brainstorm.exception.ResourceNotFoundException;
import com.brainstorm.model.Tarea;
import com.brainstorm.repository.TareasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class TareaController {

    @Autowired
    TareasRepository tareasRepository;

    @GetMapping("/tareas")
    public List<Tarea> getAll() {
        return tareasRepository.findAll();
    }

    @PostMapping("/tareas")
    public Tarea create(@Valid @RequestBody Tarea tarea) {
        return tareasRepository.save(tarea);
    }

    @GetMapping("/tareas/{id}")
    public Tarea getById(@PathVariable(value = "id") Long tareaId) {
        return tareasRepository.findById(tareaId)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea", "id", tareaId));
    }

    @PutMapping("/tareas/{id}")
    public Tarea update(@PathVariable(value = "id") Long tareaId,
                                           @Valid @RequestBody Tarea tareaDetails) {

        Tarea tarea = tareasRepository.findById(tareaId)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea", "id", tareaId));

        tarea.setDescripcion(tareaDetails.getDescripcion());
        tarea.setResponsable(tareaDetails.getResponsable());
        tarea.setStatusId(tareaDetails.getStatusId());
        tarea.setFechaComprometida(tareaDetails.getFechaComprometida());
        tarea.setPuntaje(tareaDetails.getPuntaje());
        tarea.setPrioridad(tareaDetails.getPrioridad());
        tarea.setIconoId(tareaDetails.getIconoId());

        Tarea tareaAcutalizada = tareasRepository.save(tarea);
        return tareaAcutalizada;
    }

    @DeleteMapping("/tareas/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long tareaId) {
        Tarea tarea = tareasRepository.findById(tareaId)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea", "id", tareaId));

        tareasRepository.delete(tarea);

        return ResponseEntity.ok().build();
    }
}
