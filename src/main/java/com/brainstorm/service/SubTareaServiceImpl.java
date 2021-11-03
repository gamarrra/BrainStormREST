package com.brainstorm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainstorm.model.SubTarea;
import com.brainstorm.model.Tarea;
import com.brainstorm.repository.SubTareasRepository;
import com.brainstorm.repository.TareasRepository;

@Service
public class SubTareaServiceImpl implements SubTareaService {
	
	@Autowired
	private SubTareasRepository subtareaRepository;

	@Override
	public SubTarea save(SubTarea subtarea) {
		subtareaRepository.save(subtarea);
		return subtarea;
	}

	@Override
	public List<SubTarea> searchAllSubTasks() {

		return subtareaRepository.searchAllSubTasks();
	}

	@Override
	public Optional<SubTarea> getById(Long subTareaId) {
		return subtareaRepository.findById(subTareaId);

	}

	@Override
	public void delete(SubTarea subtarea) {
		subtareaRepository.delete(subtarea);
	}
}
