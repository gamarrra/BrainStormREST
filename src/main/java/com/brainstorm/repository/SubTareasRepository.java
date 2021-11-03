package com.brainstorm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brainstorm.model.SubTarea;



@Repository
public interface SubTareasRepository extends JpaRepository<SubTarea, Long> {

	@Query(value = "select * from sub_tareas inner join on tareas tareas.tarea_id = tarea_origen_tarea_id", nativeQuery = true)
	List<SubTarea>searchAllSubTasks();
}

