package com.brainstorm.model;

import javax.persistence.Column;
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
@Table(name = "estados")
public class Estado {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estadoId;
	
	@Column(name = "estado", nullable = false, length = 100)
    private String estado;

	public Long getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Long estadoId) {
		this.estadoId = estadoId;
	}

	public String getDescripcion() {
		return estado;
	}

	public void setDescripcion(String descripcion) {
		this.estado = descripcion;
	}
    
    

}
