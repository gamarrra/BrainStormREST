package com.brainstorm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brainstorm.model.SubTarea;



@Repository
public interface SubTareasRepository extends JpaRepository<SubTarea, Long> {

}
