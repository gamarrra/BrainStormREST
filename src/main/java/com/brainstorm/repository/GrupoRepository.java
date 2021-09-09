package com.brainstorm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brainstorm.model.Grupo;




@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {

}
