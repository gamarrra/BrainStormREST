package com.brainstorm.controller;

import com.brainstorm.exception.InvalidRequestException;
import com.brainstorm.exception.ResourceNotFoundException;
import com.brainstorm.model.Grupo;
import com.brainstorm.model.Tarea;

import com.brainstorm.repository.GrupoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GrupoController {

	@Autowired
	GrupoRepository grupoRepository;

	@GetMapping("/grupos")
	public List<Grupo> getAll() {
		return grupoRepository.findAll();
	}

	@PutMapping("/grupos")
	public Grupo update(@Valid @RequestBody Grupo grupoUp) {

		Grupo grupo = grupoRepository.findById(grupoUp.getGrupoId())
				.orElseThrow(() -> new ResourceNotFoundException("grupo", "id", grupoUp.getGrupoId()));

		grupo.setDescripcion(grupoUp.getDescripcion());
		grupo.setListaTareas(grupoUp.getListaTareas());
		

		Grupo grupoAcutalizado = grupoRepository.save(grupo);
		
		return grupoAcutalizado;
	}

	@DeleteMapping("/grupos/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long grupoId) {
		Grupo grupo = grupoRepository.findById(grupoId)
				.orElseThrow(() -> new ResourceNotFoundException("grupo", "id", grupoId));

		grupoRepository.delete(grupo);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/grupos")
	public Grupo create(@Valid @RequestBody Grupo grupo) {

    	if (grupo == null || grupo.getDescripcion() == null) {
            throw new InvalidRequestException("El grupo o su descripción no pueden ser nulos");
        }
        return grupoRepository.save(grupo);

	}
}

//		List<grupo> list = grupoRepository.findAll();
//		grupoRepository.
//		grupo userList = new grupo();
//		
//		 for (int i=0;i<list.size();i++) {
//			 userList = list.get(i);
//			if (userList.getEmail() == grupo.getEmail()) {
//				return userList;
//			}
//		}
//			grupo user = new grupo();
//			user.setNombreApellido(grupo.getEmail());
//			user.setEmail(grupo.getEmail());
//			grupoRepository.save(user);
//			return user;
//		}
//		
