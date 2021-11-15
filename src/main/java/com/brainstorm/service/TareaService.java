package com.brainstorm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import com.brainstorm.model.Tarea;

public interface TareaService {
	
	public Tarea save(Tarea tarea);
	
	public List<Tarea> getAll();
	
	public Optional<Tarea> getById(Long tareaId);
	
	public void delete(Tarea tarea);

	public List <Tarea> searchAll();
	
	public List <Tarea> getTaskGroup();
	
	public Optional<List<Tarea>>getByEmailResponsable(String email);
}
