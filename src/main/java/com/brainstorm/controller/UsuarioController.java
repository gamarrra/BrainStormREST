package com.brainstorm.controller;

import com.brainstorm.exception.ResourceNotFoundException;
import com.brainstorm.model.Grupo;
import com.brainstorm.model.SubTarea;
import com.brainstorm.model.Tarea;
import com.brainstorm.model.Usuario;
import com.brainstorm.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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

	@PostMapping("/usuarios")
	public Usuario create(@Valid @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@GetMapping("/usuarios/{id}")
	public Usuario getById(@PathVariable(value = "id") Long usuarioId) {
		return usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", usuarioId));
	}

	@PutMapping("/usuarios/{id}")
	public Usuario update(@PathVariable(value = "id") Long usuarioId, @Valid @RequestBody Usuario usuarioDetails) {

		Usuario usuario = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", usuarioId));

		usuario.setNombreApellido(usuarioDetails.getNombreApellido());
		usuario.setListGrupos(usuarioDetails.getListGrupos());
		usuario.setListTareasCreadas(usuarioDetails.getListTareasCreadas());
		usuario.setListTareasResponsable(usuarioDetails.getListTareasResponsable());
		usuario.setListSubTareasCreadas(usuarioDetails.getListSubTareasCreadas());
		usuario.setListSubTareasResponsable(usuarioDetails.getListSubTareasResponsable());
		usuario.setEmail(usuarioDetails.getEmail());
		usuario.setNacionalidad(usuarioDetails.getNacionalidad());
		usuario.setDocumento(usuarioDetails.getDocumento());
		usuario.setSexo(usuarioDetails.getSexo());
		usuario.setUsuarioActivo(usuarioDetails.isUsuaarioActivo());
		usuario.setUsuarioFullAccess(usuarioDetails.isUsuarioFullAccess());

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

	@PutMapping("/usuarios/{email}")
	public Usuario createIfNotExits(@PathVariable(value = "email") String email) {

		List<Usuario> list = usuarioRepository.findAll();
		Usuario userToSave = new Usuario();
		boolean exists = false;

		for (Usuario user : list) {
			if (user.getEmail() == email) {
				exists = true;
				userToSave=user;
			}
		}
		if (exists == false) {

			List<Grupo> listGrupos = new ArrayList<>();
			List<Tarea> listTareasCreadas = new ArrayList<>();
			List<Tarea> listTareasResponsable = new ArrayList<>();
			List<SubTarea> listSubTareasCreadas = new ArrayList<>();
			List<SubTarea> listSubTareasResponsable = new ArrayList<>();
			userToSave.setNombreApellido(email);
			userToSave.setDocumento("");
			userToSave.setEmail(email);
			userToSave.setListGrupos(listGrupos);
			userToSave.setListTareasCreadas(listTareasCreadas);
			userToSave.setListSubTareasResponsable(listSubTareasResponsable);
			userToSave.setListSubTareasCreadas(listSubTareasCreadas);
			userToSave.setListTareasResponsable(listTareasResponsable);
			userToSave.setUsuarioActivo(true);
			usuarioRepository.save(userToSave);
		}
		return userToSave;
	}

}
