package com.brainstorm.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GrupoTest {
	
	private Grupo grupo =new Grupo();

	@Test
	void testGetGrupoId() {
		grupo.setGrupoId(0L);
		assertNotNull(grupo.getGrupoId());
	}

	@Test
	void testSetGrupoId() {
		grupo.setGrupoId(0L);
		assertNotNull(grupo.getGrupoId());
	}

	@Test
	void testGetCreadorId() {
		grupo.setCreadorId(0L);
		assertNotNull(grupo.getCreadorId());
	}

	@Test
	void testSetCreadorId() {
		grupo.setCreadorId(0L);
		assertNotNull(grupo.getCreadorId());
	}


	@Test
	void testGetNombre() {
		grupo.setNombre("");
		assertNotNull(grupo.getNombre());
	}

	@Test
	void testSetNombre() {
		grupo.setNombre("");
		assertNotNull(grupo.getNombre());
	}

	@Test
	void testGetIconoId() {
		grupo.setIconoId(1);
		assertNotNull(grupo.getIconoId());
	}

	@Test
	void testSetIconoId() {
		grupo.setIconoId(1);
		assertNotNull(grupo.getIconoId());
	}

}
