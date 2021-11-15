package com.brainstorm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.brainstorm.model.Grupo;
import com.brainstorm.model.SubTarea;
import com.brainstorm.model.Tarea;
import com.brainstorm.model.Usuario;



@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {
	
	@Query("select s from Grupo s where s.nombre = :nombre")
	List<Grupo> findByNombre(@Param("nombre") String nombre);

}

