package com.brainstorm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "estados")
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "estadoId")
public class Estado implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estadoId;

	@Column(name = "estado", nullable = false, length = 100)
    private String estado;
	
	@OneToMany(mappedBy = "estado", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonManagedReference(value="user-estado")
    private List<Tarea> listaTareasxEstado = new ArrayList<>();
	
	public List<Tarea> getListaTareasxEstado() {
		return listaTareasxEstado;
	}

	public void setListaTareasxEstado(List<Tarea> listaTareasxEstado) {
		this.listaTareasxEstado = listaTareasxEstado;
	}

	public Long getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Long estadoId) {
		this.estadoId = estadoId;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

    
    

}
