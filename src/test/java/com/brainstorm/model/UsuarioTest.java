package com.brainstorm.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UsuarioTest {

	private Usuario user=new Usuario();
	
	@Test
	void testGetUsuarioId() {
		user.setUsuarioId(0L);
		assertNotNull(user.getUsuarioId());
	}

	@Test
	void testSetUsuarioId() {
		user.setUsuarioId(0L);
		assertNotNull(user.getUsuarioId());
	}

	@Test
	void testGetNombreApellido() {
		user.setNombreApellido("");
		assertNotNull(user.getNombreApellido());
	}

	@Test
	void testSetNombreApellido() {
		user.setNombreApellido("");
		assertNotNull(user.getNombreApellido());
	}

	@Test
	void testGetNacionalidad() {
		user.setNacionalidad("");
		assertNotNull(user.getNacionalidad());
	}

	@Test
	void testSetNacionalidad() {
		user.setNacionalidad("");
		assertNotNull(user.getNacionalidad());
	}

	@Test
	void testGetDocumento() {
		user.setDocumento("");
		assertNotNull(user.getDocumento());
	}

	@Test
	void testSetDocumento() {
		user.setDocumento("");
		assertNotNull(user.getDocumento());
	}

	@Test
	void testGetSexo() {
		user.setSexo("");
		assertNotNull(user.getSexo());
	}

	@Test
	void testSetSexo() {
		user.setSexo("");
		assertNotNull(user.getSexo());
	}

	@Test
	void testGetEmail() {
		user.setEmail("");
		assertNotNull(user.getEmail());
	}

	@Test
	void testSetEmail() {
		user.setEmail("");
		assertNotNull(user.getEmail());
	}

}
