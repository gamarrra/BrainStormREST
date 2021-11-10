package com.brainstorm.controller;

import com.brainstorm.exception.ResourceNotFoundException;
import com.brainstorm.model.Tarea;
import com.brainstorm.repository.TareasRepository;
import com.brainstorm.service.TareaService;
import com.brainstorm.exception.InvalidRequestException;
import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping("/tareas")
    public List<Tarea> SearchAll() {
        return tareaService.SearchAll();
    }

    @PostMapping("/tareas")
    public Tarea create(@Valid @RequestBody Tarea tarea) {
    	if (tarea == null || tarea.getDescripcion() == null) {
            throw new InvalidRequestException("La Tarea o su descripción no pueden ser nulos");
        }
        return tareaService.save(tarea);
    }

    @GetMapping("/tareas/{id}")
    public Tarea getById(@PathVariable(value = "id") Long tareaId) {
        return tareaService.getById(tareaId)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea", "id", tareaId));
    }

    @PutMapping("/tareas/{id}")
    public Tarea update(@PathVariable(value = "id") Long tareaId,
                                           @Valid @RequestBody Tarea tareaDetails) throws NotFoundException{

    	if (tareaDetails == null || tareaDetails.getTareaId() == null) {
            throw new InvalidRequestException("La Tarea o la tareaId no pueden ser nulos");
        }
        Optional<Tarea> optionalTarea = tareaService.getById(tareaDetails.getTareaId());
        if (optionalTarea.isEmpty()) {
            throw new NotFoundException("Tarea con ID " + tareaDetails.getTareaId() + " no existe.");
        }
        Tarea tareaExistente = optionalTarea.get();

        tareaExistente.setDescripcion(tareaDetails.getDescripcion());
        tareaExistente.setListaSubTareas(tareaDetails.getListaSubTareas());
        tareaExistente.setEstado(tareaDetails.getEstado());
        tareaExistente.setFechaComprometida(tareaDetails.getFechaComprometida());
        tareaExistente.setUsuarioEmailResponsable(tareaDetails.getUsuarioEmailResponsable());

        Tarea tareaAcutalizada = tareaService.save(tareaExistente);
        return tareaAcutalizada;
    }

    @DeleteMapping("/tareas/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long tareaId){
        Tarea tarea = tareaService.getById(tareaId)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea", "id", tareaId));
        
        tareaService.delete(tarea);

        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/tareasGrupo")
    public List<Tarea> GetTaskGroup() {
        return tareaService.GetTaskGroup();
    }

}
