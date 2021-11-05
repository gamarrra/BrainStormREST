package com.brainstorm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@JsonManagedReference
	@OneToMany(mappedBy = "usuarioCreadorGrupo", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Grupo> listGrupos = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "usuarioCreador", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Tarea> listTareasCreadas = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "usuarioResponsable", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Tarea> listTareasResponsable = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "usuarioCreadorSubTarea", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<SubTarea> listSubTareasCreadas = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "usuarioResponsableSubTarea", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<SubTarea> listSubTareasResponsable = new ArrayList<>();
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@NotBlank
	private String email;
	
	private String nacionalidad;

	private String documento;

	private String sexo;

	private boolean usuarioActivo;
	
	private boolean usuarioFullAccess;
	
	
	
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

	public List<Grupo> getListGrupos() {
		return listGrupos;
	}

	public void setListGrupos(List<Grupo> listGrupos) {
		this.listGrupos = listGrupos;
	}

	public List<Tarea> getListTareasCreadas() {
		return listTareasCreadas;
	}

	public void setListTareasCreadas(List<Tarea> listTareasCreadas) {
		this.listTareasCreadas = listTareasCreadas;
	}

	public List<Tarea> getListTareasResponsable() {
		return listTareasResponsable;
	}

	public void setListTareasResponsable(List<Tarea> listTareasResponsable) {
		this.listTareasResponsable = listTareasResponsable;
	}

	public List<SubTarea> getListSubTareasCreadas() {
		return listSubTareasCreadas;
	}

	public void setListSubTareasCreadas(List<SubTarea> listSubTareasCreadas) {
		this.listSubTareasCreadas = listSubTareasCreadas;
	}

	public List<SubTarea> getListSubTareasResponsable() {
		return listSubTareasResponsable;
	}

	public void setListSubTareasResponsable(List<SubTarea> listSubTareasResponsable) {
		this.listSubTareasResponsable = listSubTareasResponsable;
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
	
	public boolean isUsuarioFullAccess() {
		return usuarioFullAccess;
	}

	public void setUsuarioFullAccess(boolean usuarioFullAccess) {
		this.usuarioFullAccess = usuarioFullAccess;
	}

}
