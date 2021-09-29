package com.brainstorm.model;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PagoTest {
	
	private Pago pago =new Pago();
	

	@Test
	void testGetPagoId() {
		pago.setPagoId(0L);
		assertNotNull(pago.getPagoId());
	}

	@Test
	void testSetPagoId() {
		pago.setPagoId(0L);
		assertNotNull(pago.getPagoId());
	}

	@Test
	void testGetUsuarioId() {
		pago.setUsuarioId(0L);
		assertNotNull(pago.getUsuarioId());
	}

	@Test
	void testSetUsuarioId() {
		pago.setUsuarioId(0L);
		assertNotNull(pago.getUsuarioId());
	}

	@Test
	void testGetCreatedAt() {
		pago.setUsuarioId(0L);
		assertNotNull(pago.getUsuarioId());
	}

}
