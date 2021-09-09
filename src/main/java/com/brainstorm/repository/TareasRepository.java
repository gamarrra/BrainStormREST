package com.brainstorm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brainstorm.model.Tarea;



@Repository
public interface TareasRepository extends JpaRepository<Tarea, Long> {

}
