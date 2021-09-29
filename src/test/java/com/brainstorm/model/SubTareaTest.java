package com.brainstorm.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

class SubTareaTest {

	private SubTarea subTarea =new SubTarea();
	
	private Date date=Calendar.getInstance().getTime();
	
	void testGetTareaId() {
		subTarea.setTareaId(0L);
		assertNotNull(subTarea.getTareaId());
	}

	@Test
	void testSetTareaId() {
		subTarea.setTareaId(0L);
		assertNotNull(subTarea.getTareaId());
	}

	@Test
	void testGetSubTareaId() {
		subTarea.setSubTareaId(0L);
		assertNotNull(subTarea.getSubTareaId());
	}

	@Test
	void testSetSubTareaId() {
		subTarea.setSubTareaId(0L);
		assertNotNull(subTarea.getSubTareaId());
	}

	@Test
	void testGetDescripcion() {
		subTarea.setDescripcion("");
		assertNotNull(subTarea.getDescripcion());
	}

	@Test
	void testSetDescripcion() {
		subTarea.setDescripcion("");
		assertNotNull(subTarea.getDescripcion());
	}

	@Test
	void testGetResponsable() {
		subTarea.setResponsable(0L);
		assertNotNull(subTarea.getResponsable());
	}

	@Test
	void testSetResponsable() {
		subTarea.setResponsable(0L);
		assertNotNull(subTarea.getResponsable());
	}

	@Test
	void testGetStatusId() {
		subTarea.setStatusId(1);
		assertNotNull(subTarea.getStatusId());
	}

	@Test
	void testSetStatusId() {
		subTarea.setStatusId(1);
		assertNotNull(subTarea.getStatusId());
	}

	@Test
	void testGetFechaComprometida() {
		subTarea.setFechaComprometida(date);
		assertNotNull(subTarea.getFechaComprometida());
	}

	@Test
	void testSetFechaComprometida() {
		subTarea.setFechaComprometida(date);
		assertNotNull(subTarea.getFechaComprometida());
	}

	@Test
	void testGetPuntaje() {
		subTarea.setPuntaje(1);
		assertNotNull(subTarea.getPuntaje());
	}

	@Test
	void testSetPuntaje() {
		subTarea.setPuntaje(1);
		assertNotNull(subTarea.getPuntaje());
	}

	@Test
	void testGetPrioridad() {
		subTarea.setPrioridad(1);
		assertNotNull(subTarea.getPrioridad());
	}

	@Test
	void testSetPrioridad() {
		subTarea.setPrioridad(1);
		assertNotNull(subTarea.getPrioridad());
	}

	@Test
	void testGetIconoId() {
		subTarea.setIconoId(1);
		assertNotNull(subTarea.getIconoId());
	}

	@Test
	void testSetIconoId() {
		subTarea.setIconoId(1);
		assertNotNull(subTarea.getIconoId());
	}

}
