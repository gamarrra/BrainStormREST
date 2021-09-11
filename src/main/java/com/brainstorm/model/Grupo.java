package com.brainstorm.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "grupos")
@EntityListeners(AuditingEntityListener.class)
public class Grupo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long grupoId;

	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario creadorId;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "tareaId")
	private List<Tarea> tareas;

	@NotBlank
	private String descripcion;

	private int iconoId;

	public Long getGrupoId() {
		return grupoId;
	}

	public void setGrupoId(Long grupoId) {
		this.grupoId = grupoId;
	}

	public Usuario getCreadorId() {
		return creadorId;
	}

	public void setCreadorId(Usuario creadorId) {
		this.creadorId = creadorId;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIconoId() {
		return iconoId;
	}

	public void setIconoId(int iconoId) {
		this.iconoId = iconoId;
	}
	
	



}
