package com.brainstorm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brainstorm.model.SubTarea;
import com.brainstorm.model.Tarea;



@Repository
public interface SubTareaRepository extends JpaRepository<SubTarea, Long> {

}

