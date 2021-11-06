package com.brainstorm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


import java.util.Date;


@Entity
@Table(name = "subTareas")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class SubTarea {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subTareaId;

	@NotBlank
    private String descripcion;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    
    @JsonManagedReference(value="usuarioCreadorSubTarea")
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuarioCreadorSubTarea;  
	
    @JsonManagedReference(value="usuarioResponsableSubTarea")
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuarioResponsableSubTarea; 
	
    @JsonManagedReference(value="tareaOrigen")
	@ManyToOne(fetch = FetchType.LAZY)
	private Tarea tareaOrigen;

	@ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Estado estado;
    
    private int puntaje;
    
    private int prioridad;
    
    private int iconoId;
    
    private Date fechaComprometida;
    
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Usuario getUsuarioCreadorSubTarea() {
		return usuarioCreadorSubTarea;
	}

	public void setUsuarioCreadorSubTarea(Usuario usuarioCreadorSubTarea) {
		this.usuarioCreadorSubTarea = usuarioCreadorSubTarea;
	}

	public Usuario getUsuarioResponsableSubTarea() {
		return usuarioResponsableSubTarea;
	}

	public void setUsuarioResponsableSubTarea(Usuario usuarioResponsableSubTarea) {
		this.usuarioResponsableSubTarea = usuarioResponsableSubTarea;
	}

	public Tarea getTareaOrigen() {
		return tareaOrigen;
	}

	public void setTareaOrigen(Tarea tareaOrigen) {
		this.tareaOrigen = tareaOrigen;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public int getIconoId() {
		return iconoId;
	}

	public void setIconoId(int iconoId) {
		this.iconoId = iconoId;
	}

	public Date getFechaComprometida() {
		return fechaComprometida;
	}

	public void setFechaComprometida(Date fechaComprometida) {
		this.fechaComprometida = fechaComprometida;
	}
	
    public Estado getEstadoSubtarea() {
		return estado;
	}

	public void setEstadoSubtarea(Estado estadoSubtarea) {
		this.estado = estadoSubtarea;
	}

}
