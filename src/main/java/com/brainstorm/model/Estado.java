package com.brainstorm.model;




import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "estados", uniqueConstraints= {@UniqueConstraint(columnNames= {"estadoId", "descripcion"})})
@EntityListeners(AuditingEntityListener.class)
public class Estado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estadoId;
	
    @NotBlank
    private String descripcion;

	public Long getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Long estadoId) {
		this.estadoId = estadoId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
