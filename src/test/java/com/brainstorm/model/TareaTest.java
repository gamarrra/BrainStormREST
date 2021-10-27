package com.brainstorm.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

class TareaTest {

	private Tarea tarea =new Tarea();
	
	private Date date=Calendar.getInstance().getTime();
	
	@Test
	void testGetTareaId() {
		tarea.setTareaId(0L);
		assertNotNull(tarea.getTareaId());
	}

	@Test
	void testSetTareaId() {
		tarea.setTareaId(0L);
		assertNotNull(tarea.getTareaId());
	}

	@Test
	void testGetDescripcion() {
		tarea.setDescripcion("");
		assertNotNull(tarea.getDescripcion());
	}

	@Test
	void testSetDescripcion() {
		tarea.setDescripcion("");
		assertNotNull(tarea.getDescripcion());
	}

	@Test
	void testGetFechaComprometida() {
		tarea.setFechaComprometida(date);
		assertNotNull(tarea.getFechaComprometida());
	}

	@Test
	void testSetFechaComprometida() {
		tarea.setFechaComprometida(date);
		assertNotNull(tarea.getFechaComprometida());
	}

	@Test
	void testGetPuntaje() {
		tarea.setPuntaje(1);
		assertNotNull(tarea.getPuntaje());
	}

	@Test
	void testSetPuntaje() {
		tarea.setPuntaje(1);
		assertNotNull(tarea.getPuntaje());
	}

	@Test
	void testGetPrioridad() {
		tarea.setPrioridad(1);
		assertNotNull(tarea.getPrioridad());
	}

	@Test
	void testSetPrioridad() {
		tarea.setPrioridad(1);
		assertNotNull(tarea.getPrioridad());
	}

	@Test
	void testGetIconoId() {
		tarea.setIconoId(1);
		assertNotNull(tarea.getIconoId());
	}

	@Test
	void testSetIconoId() {
		tarea.setIconoId(1);
		assertNotNull(tarea.getIconoId());
	}

}
