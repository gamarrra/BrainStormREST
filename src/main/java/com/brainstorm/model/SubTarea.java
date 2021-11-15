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
@Table(name = "subtareas")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
@JsonIdentityInfo(		
		scope = SubTarea.class,
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "subTareaId")
public class SubTarea implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subTareaId;

	@NotBlank
    private String descripcion;

	@ManyToOne
	@JsonBackReference(value="tarea-subtarea")
	private Tarea tareaCreadora; 
	
    private String estado;
    
	private String usuarioEmailResponsable;
	
	private Date fechaComprometida;
	
    public Date getFechaComprometida() {
		return fechaComprometida;
	}

	public void setFechaComprometida(Date fechaComprometida) {
		this.fechaComprometida = fechaComprometida;
	}

	public void setUsuarioEmailResponsable(String usuarioEmailResponsable) {
		this.usuarioEmailResponsable = usuarioEmailResponsable;
	}

	public String getUsuarioEmailResponsable() {
		return usuarioEmailResponsable;
	}

    
    public Long getSubTareaId() {
		return subTareaId;
	}

	public void setSubTareaId(Long subTareaId) {
		this.subTareaId = subTareaId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
    
	public Tarea getTareaCreadora() {
		return tareaCreadora;
	}

	public void setTareaCreadora(Tarea tareaCreadora) {
		this.tareaCreadora = tareaCreadora;
	}
}
