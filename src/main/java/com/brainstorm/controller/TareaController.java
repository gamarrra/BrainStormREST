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
@RequestMapping("/usuario")
public class TareaController {

    @Autowired
    TareasRepository tareasRepository;

    @GetMapping("/tareas")
    public List<Tarea> getAllTareas() {
        return tareasRepository.findAll();
    }

    @PostMapping("/tareas")
    public Tarea createNote(@Valid @RequestBody Tarea tarea) {
        return tareasRepository.save(tarea);
    }

    @GetMapping("/tareas/{id}")
    public Tarea getNoteById(@PathVariable(value = "id") Long tareaId) {
        return tareasRepository.findById(tareaId)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea", "id", tareaId));
    }

    @PutMapping("/tareas/{id}")
    public Tarea updateNote(@PathVariable(value = "id") Long tareaId,
                                           @Valid @RequestBody Tarea tareaDetails) {

        Tarea tarea = tareasRepository.findById(tareaId)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea", "id", tareaId));

        tarea.setDescripcion(tareaDetails.getDescripcion());
        tarea.setResponsable(tareaDetails.getResponsable());
        tarea.setEstado(tareaDetails.getEstado());
        tarea.setFechaComprometida(tareaDetails.getFechaComprometida());
        tarea.setPuntaje(tareaDetails.getPuntaje());
        tarea.setPrioridad(tareaDetails.getPrioridad());
        tarea.setIconoId(tareaDetails.getIconoId());

        Tarea tareaAcutalizada = tareasRepository.save(tarea);
        return tareaAcutalizada;
    }

    @DeleteMapping("/tareas/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long tareaId) {
        Tarea tarea = tareasRepository.findById(tareaId)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea", "id", tareaId));

        tareasRepository.delete(tarea);

        return ResponseEntity.ok().build();
    }
}
