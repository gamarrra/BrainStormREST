package com.brainstorm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuarioId;

	@NotBlank
	private String nombreApellido;

	private String nacionalidad;

	private String documento;

	private String sexo;

	private boolean usuarioActivo;
	
	private boolean usuarioFullAccess;
	
	@OneToMany(mappedBy = "usuarioCreador", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Tarea> listTareasCreadas = new ArrayList<>();
	
	@OneToMany(mappedBy = "usuarioResponsable", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Tarea> listTareasResponsable = new ArrayList<>();
	
	@OneToMany(mappedBy = "usuarioCreadorSubTarea", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<SubTarea> listSubTareasCreadas = new ArrayList<>();
	
	@OneToMany(mappedBy = "usuarioResponsableSubTarea", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<SubTarea> listSubTareasResponsable = new ArrayList<>();

	@NotBlank
	private String email;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

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

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean isUsuaarioActivo() {
		return usuarioActivo;
	}

	public void setUsuarioActivo(boolean usuarioActivo) {
		this.usuarioActivo = usuarioActivo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public boolean isUsuarioFullAccess() {
		return usuarioFullAccess;
	}

	public void setUsuarioFullAccess(boolean usuarioFullAccess) {
		this.usuarioFullAccess = usuarioFullAccess;
	}

}
