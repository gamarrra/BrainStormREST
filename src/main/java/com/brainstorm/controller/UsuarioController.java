package com.brainstorm.controller;

import com.brainstorm.exception.ResourceNotFoundException;
import com.brainstorm.model.Tarea;
import com.brainstorm.model.Usuario;
import com.brainstorm.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping("/usuarios")
	public List<Usuario> getAll() {
		return usuarioRepository.findAll();
	}

	@PutMapping("/usuarios/{id}")
	public Usuario update(@PathVariable(value = "id") Long usuarioId, @Valid @RequestBody Usuario usuarioDetails) {

		Usuario usuario = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", usuarioId));

		usuario.setNombreApellido(usuarioDetails.getNombreApellido());
		usuario.setListTareasCreadas(usuarioDetails.getListTareasCreadas());
		usuario.setEmail(usuarioDetails.getEmail());

		Usuario usuarioAcutalizado = usuarioRepository.save(usuario);
		return usuarioAcutalizado;
	}

	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long usuarioId) {
		Usuario usuario = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", usuarioId));

		usuarioRepository.delete(usuario);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/usuarios")
	public Usuario create(@Valid @RequestBody Usuario usuario) {

		List<Usuario> users = usuarioRepository.findByEmail(usuario.getEmail());
		if (users.size() < 1) 
		{
			Usuario user = new Usuario();
			user.setEmail(usuario.getEmail());
			user.setNombreApellido(usuario.getEmail());
			usuarioRepository.save(user);
			return user;
		}
		else {
			usuario=users.get(0);
		}
		return usuario;

	}
}

//		List<Usuario> list = usuarioRepository.findAll();
//		usuarioRepository.
//		Usuario userList = new Usuario();
//		
//		 for (int i=0;i<list.size();i++) {
//			 userList = list.get(i);
//			if (userList.getEmail() == usuario.getEmail()) {
//				return userList;
//			}
//		}
//			Usuario user = new Usuario();
//			user.setNombreApellido(usuario.getEmail());
//			user.setEmail(usuario.getEmail());
//			usuarioRepository.save(user);
//			return user;
//		}
//		
