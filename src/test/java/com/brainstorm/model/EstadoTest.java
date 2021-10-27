package com.brainstorm.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EstadoTest {

	private Estado estado =new Estado();
	
	
	@Test
	void testGetEstadoId() {
		estado.setEstadoId(0L);
		assertNotNull(estado.getEstadoId());
	}

	@Test
	void testSetEstadoId() {
		estado.setEstadoId(0L);
		assertNotNull(estado.getEstadoId());
	}

}
