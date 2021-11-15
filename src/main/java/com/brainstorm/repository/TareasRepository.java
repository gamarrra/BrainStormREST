package com.brainstorm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.brainstorm.model.Tarea;
import com.brainstorm.model.Usuario;



@Repository
public interface TareasRepository extends JpaRepository<Tarea, Long> {
	
	@Query(value = "select * from tareas",nativeQuery=true)
	List <Tarea> SearchAll();
	
	@Query(value = "select * from tareas inner join grupos on tareas.grupo_grupo_id = grupos.grupo_id;", nativeQuery=true)
	List <Tarea> GetTaskGroup();
	
	@Query("select s from Tarea s where s.usuarioEmailResponsable = :email")
	Optional<List<Tarea>> findByusuarioEmailResponsable(@Param("email") String email);
}

