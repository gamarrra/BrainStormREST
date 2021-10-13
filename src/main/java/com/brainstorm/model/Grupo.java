package com.brainstorm.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "grupos")
@EntityListeners(AuditingEntityListener.class)
public class Grupo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long grupoId;

	private Long creadorId;

	private Long tareaId;

	@NotBlank
	private String nombre;

	private int iconoId;
	
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getGrupoId() {
		return grupoId;
	}

	public void setGrupoId(Long grupoId) {
		this.grupoId = grupoId;
	}

	public Long getCreadorId() {
		return creadorId;
	}

	public void setCreadorId(Long creadorId) {
		this.creadorId = creadorId;
	}

	public Long getTareaId() {
		return tareaId;
	}

	public void setTareaId(Long tareaId) {
		this.tareaId = tareaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIconoId() {
		return iconoId;
	}

	public void setIconoId(int iconoId) {
		this.iconoId = iconoId;
	}


}
