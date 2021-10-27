package com.brainstorm.model;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "grupos")
public class Grupo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long grupoId;

	private Long creadorId;
	
	@OneToMany(mappedBy = "grupo", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Tarea> listTareas = new ArrayList<>();

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
	
    public List<Tarea> getListTareas() {
		return listTareas;
	}

	public void setListTareas(List<Tarea> listTareas) {
		this.listTareas = listTareas;
	}


}
