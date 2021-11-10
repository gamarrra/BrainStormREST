package com.brainstorm.controller;

import com.brainstorm.exception.InvalidRequestException;
import com.brainstorm.exception.ResourceNotFoundException;
import com.brainstorm.model.SubTarea;
import com.brainstorm.model.Tarea;

import com.brainstorm.repository.SubTareaRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SubTareaController {

	@Autowired
	SubTareaRepository subTareaRepository;

	@GetMapping("/subtareas")
	public List<SubTarea> getAll() {
		return subTareaRepository.findAll();
	}

	@PutMapping("/subTareas")
	public SubTarea update(@Valid @RequestBody SubTarea subTareaUp) {

		SubTarea subTarea = subTareaRepository.findById(subTareaUp.getSubTareaId())
				.orElseThrow(() -> new ResourceNotFoundException("SubTarea", "id", subTareaUp.getSubTareaId()));

		subTarea.setDescripcion(subTareaUp.getDescripcion());
		subTarea.setEstado(subTareaUp.getEstado());
		subTarea.setUsuarioEmailResponsable(subTareaUp.getUsuarioEmailResponsable());	
		subTarea.setFechaComprometida(subTareaUp.getFechaComprometida());

		SubTarea SubTareaAcutalizado = subTareaRepository.save(subTarea);
		
		return SubTareaAcutalizado;
	}

	@DeleteMapping("/subTareas/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long subTareaId) {
		SubTarea subTarea = subTareaRepository.findById(subTareaId)
				.orElseThrow(() -> new ResourceNotFoundException("SubTarea", "id", subTareaId));

		subTareaRepository.delete(subTarea);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/subTareas")
	public SubTarea create(@Valid @RequestBody SubTarea subTarea) {

    	if (subTarea == null || subTarea.getDescripcion() == null) {
            throw new InvalidRequestException("La SubTarea o su descripción no pueden ser nulos");
        }
        return subTareaRepository.save(subTarea);

	}
}

//		List<SubTarea> list = SubTareaRepository.findAll();
//		SubTareaRepository.
//		SubTarea userList = new SubTarea();
//		
//		 for (int i=0;i<list.size();i++) {
//			 userList = list.get(i);
//			if (userList.getEmail() == SubTarea.getEmail()) {
//				return userList;
//			}
//		}
//			SubTarea user = new SubTarea();
//			user.setNombreApellido(SubTarea.getEmail());
//			user.setEmail(SubTarea.getEmail());
//			SubTareaRepository.save(user);
//			return user;
//		}
//		
