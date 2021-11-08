package com.brainstorm.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "usuarioId")
public class Usuario implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuarioId;

	@NotBlank
	private String nombreApellido;
	
	@OneToMany(mappedBy = "usuarioCreador", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonManagedReference(value="user-tarea")
    private List<Tarea> listTareasCreadas = new ArrayList<>();

	@NotBlank
	private String email;
	
	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public List<Tarea> getListTareasCreadas() {
		return listTareasCreadas;
	}

	public void setListTareasCreadas(List<Tarea> listTareasCreadas) {
		this.listTareasCreadas = listTareasCreadas;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
