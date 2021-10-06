package com.brainstorm.controller;

import com.brainstorm.exception.ResourceNotFoundException;
import com.brainstorm.model.Tarea;
import com.brainstorm.repository.TareasRepository;
import com.brainstorm.service.TareaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping("/tareas")
    public List<Tarea> getAll() {
        return tareaService.getAll();
    }

    @PostMapping("/tareas")
    public Tarea create(@Valid @RequestBody Tarea tarea) {
        return tareaService.save(tarea);
    }

    @GetMapping("/tareas/{id}")
    public Tarea getById(@PathVariable(value = "id") Long tareaId) {
        return tareaService.getById(tareaId)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea", "id", tareaId));
    }

    @PutMapping("/tareas/{id}")
    public Tarea update(@PathVariable(value = "id") Long tareaId,
                                           @Valid @RequestBody Tarea tareaDetails) {

        Tarea tarea = tareaService.getById(tareaId)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea", "id", tareaId));

        tarea.setDescripcion(tareaDetails.getDescripcion());
        tarea.setResponsable(tareaDetails.getResponsable());
        tarea.setStatusId(tareaDetails.getStatusId());
        tarea.setFechaComprometida(tareaDetails.getFechaComprometida());
        tarea.setPuntaje(tareaDetails.getPuntaje());
        tarea.setPrioridad(tareaDetails.getPrioridad());
        tarea.setIconoId(tareaDetails.getIconoId());

        Tarea tareaAcutalizada = tareaService.save(tarea);
        return tareaAcutalizada;
    }

    @DeleteMapping("/tareas/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long tareaId) {
        Tarea tarea = tareaService.getById(tareaId)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea", "id", tareaId));

        tareaService.delete(tarea);

        return ResponseEntity.ok().build();
    }
}
