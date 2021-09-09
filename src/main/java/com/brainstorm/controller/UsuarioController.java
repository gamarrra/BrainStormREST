package com.brainstorm.controller;

import com.brainstorm.exception.ResourceNotFoundException;
import com.brainstorm.model.Tarea;
import com.brainstorm.model.Usuario;
import com.brainstorm.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class UsuarioController {

	
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List<Usuario> getAllTareas() {
        return usuarioRepository.findAll();
    }

    @PostMapping("/usuarios")
    public Usuario createNote(@Valid @RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/usuarios/{id}")
    public Usuario getNoteById(@PathVariable(value = "id") Long usuarioId) {
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", usuarioId));
    }

    @PutMapping("/usuarios/{id}")
    public Usuario updateNote(@PathVariable(value = "id") Long usuarioId,
                                           @Valid @RequestBody Usuario usuarioDetails) {

    	Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", usuarioId));

    	usuario.setNombreApellido(usuarioDetails.getNombreApellido());
    	usuario.setNacionalidad(usuarioDetails.getNacionalidad());
    	usuario.setDocumento(usuarioDetails.getDocumento());
    	usuario.setSexo(usuarioDetails.getSexo());
    	usuario.setUsuarioActivo(usuarioDetails.isUsuaarioActivo());
    	usuario.setEmail(usuarioDetails.getEmail());

        Usuario usuarioAcutalizado = usuarioRepository.save(usuario);
        return usuarioAcutalizado;
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long usuarioId) {
    	Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", usuarioId));

        usuarioRepository.delete(usuario);

        return ResponseEntity.ok().build();
    }
}
