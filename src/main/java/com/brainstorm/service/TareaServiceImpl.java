package com.brainstorm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainstorm.model.Tarea;
import com.brainstorm.repository.TareasRepository;

@Service
public class TareaServiceImpl implements TareaService {
	
	@Autowired
	private TareasRepository tareaRepository;

	@Override
	public Tarea save(Tarea tarea) {
		tareaRepository.save(tarea);
		return tarea;
	}

	@Override
	public List<Tarea> getAll() {

		return tareaRepository.findAll();
	}

	@Override
	public Optional<Tarea> getById(Long tareaId) {
		return tareaRepository.findById(tareaId);

	}

	@Override
	public void delete(Tarea tarea) {
		tareaRepository.delete(tarea);
	}
	
	@Override 
	public List<Tarea>searchAll(){
		return tareaRepository.SearchAll();
	}
	
	@Override
	public List<Tarea>getTaskGroup(){
		return tareaRepository.GetTaskGroup();
	}
	
	@Override
	public Optional<List<Tarea>>getByEmailResponsable(String email){
		return tareaRepository.findByusuarioEmailResponsable(email);
	}
}
