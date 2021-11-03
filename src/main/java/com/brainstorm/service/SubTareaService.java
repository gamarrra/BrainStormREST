package com.brainstorm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import com.brainstorm.model.SubTarea;
import com.brainstorm.model.Tarea;

public interface SubTareaService {
	
	public SubTarea save(SubTarea subTarea);
	
	public List<SubTarea> searchAllSubTasks();
	
	public Optional<SubTarea> getById(Long subTareaId);
	
	public void delete(SubTarea subTarea);

}
