package com.brainstorm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "tareas")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Tarea {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tareaId;

    @NotBlank
    private String descripcion;

	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuarioCreador;  
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuarioResponsable;   
    
    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Estado estado;

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
    
	public List<SubTarea> getListSubTareas() {
		return listSubTareas;
	}

	public void setListSubTareas(List<SubTarea> listSubTareas) {
		this.listSubTareas = listSubTareas;
	}

	@OneToMany(mappedBy = "tareaOrigen", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<SubTarea> listSubTareas = new ArrayList<>();
    
    @ManyToOne(fetch = FetchType.LAZY)
	private Grupo grupo;
    
    public Grupo getGrupoId() {
		return grupo;
	}

	public void setGrupoId(Grupo grupo) {
		this.grupo = grupo;
	}

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
