package com.brainstorm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    
    private int statusId;

    private Date fechaComprometida;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    
    private int puntaje;
    
    private int prioridad;
    
    private int iconoId;
    
    private long tareaId;
    
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuarioCreadorSubTarea;  
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuarioResponsableSubTarea;  
    
    public Tarea getTarea() {
		return tareaOrigen;
	}

	public void setTarea(Tarea tarea) {
		this.tareaOrigen = tarea;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	private Tarea tareaOrigen;


	public long getTareaId() {
		return tareaId;
	}

	public void setTareaId(long tareaId) {
		this.tareaId = tareaId;
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

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public Date getFechaComprometida() {
		return fechaComprometida;
	}

	public void setFechaComprometida(Date fechaComprometida) {
		this.fechaComprometida = fechaComprometida;
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
    

}
