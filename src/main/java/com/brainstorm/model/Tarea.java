package com.brainstorm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "tareas")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "tareaId")
public class Tarea implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tareaId;

	@NotBlank
    private String descripcion;

	@ManyToOne
	@JsonBackReference(value="user-tarea")
	private Usuario usuarioCreador; 
	
    @ManyToOne
    @JsonBackReference(value="user-estado")
    private Estado estado;
    
    public Long getTareaId() {
		return tareaId;
	}

	public void setTareaId(Long tareaId) {
		this.tareaId = tareaId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getUsuarioCreador() {
		return usuarioCreador;
	}

	public void setUsuarioCreador(Usuario usuarioCreador) {
		this.usuarioCreador = usuarioCreador;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
    
}
