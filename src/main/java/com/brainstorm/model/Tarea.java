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
		scope = Tarea.class,
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
	@JsonBackReference(value="grupo-tarea")
	private Grupo grupoCreador; 
	
	@OneToMany(mappedBy = "tareaCreadora", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonManagedReference(value="tarea-subtarea")
    private List<SubTarea> listaSubTareas = new ArrayList<>();
	
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


	public List<SubTarea> getListaSubTareas() {
		return listaSubTareas;
	}

	public void setListaSubTareas(List<SubTarea> listaSubTareas) {
		this.listaSubTareas = listaSubTareas;
	}

	private String estado;
    
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

	public Grupo getGrupoCreador() {
		return grupoCreador;
	}

	public void setGrupoCreador(Grupo grupoCreador) {
		this.grupoCreador = grupoCreador;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
    
}
