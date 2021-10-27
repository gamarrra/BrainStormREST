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

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    
	@OneToMany(mappedBy = "tareaOrigen", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<SubTarea> listSubTareas = new ArrayList<>();
    
    @ManyToOne(fetch = FetchType.LAZY)
	private Grupo grupo;
    
    private Date fechaComprometida;
    
    private int puntaje;
    
    private int prioridad;
    
    private int iconoId;
    
    

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

	public Usuario getUsuarioResponsable() {
		return usuarioResponsable;
	}

	public void setUsuarioResponsable(Usuario usuarioResponsable) {
		this.usuarioResponsable = usuarioResponsable;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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

	public List<SubTarea> getListSubTareas() {
		return listSubTareas;
	}

	public void setListSubTareas(List<SubTarea> listSubTareas) {
		this.listSubTareas = listSubTareas;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Date getFechaComprometida() {
		return fechaComprometida;
	}

	public void setFechaComprometida(Date fechaComprometida) {
		this.fechaComprometida = fechaComprometida;
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
