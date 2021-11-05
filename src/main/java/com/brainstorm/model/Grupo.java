package com.brainstorm.model;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "grupos")
public class Grupo {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long grupoId;
	
	@NotBlank
	private String nombre;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuarioCreadorGrupo;  
	
	@JsonManagedReference
	@OneToMany(mappedBy = "grupo", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Tarea> listTareas = new ArrayList<>();

	private int iconoId;
	
	private String descripcion;
	
	
	
	
	public Long getGrupoId() {
		return grupoId;
	}

	public void setGrupoId(Long grupoId) {
		this.grupoId = grupoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Usuario getUsuarioCreadorGrupo() {
		return usuarioCreadorGrupo;
	}

	public void setUsuarioCreadorGrupo(Usuario usuarioCreadorGrupo) {
		this.usuarioCreadorGrupo = usuarioCreadorGrupo;
	}

	public List<Tarea> getListTareas() {
		return listTareas;
	}

	public void setListTareas(List<Tarea> listTareas) {
		this.listTareas = listTareas;
	}

	public int getIconoId() {
		return iconoId;
	}

	public void setIconoId(int iconoId) {
		this.iconoId = iconoId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	

}
