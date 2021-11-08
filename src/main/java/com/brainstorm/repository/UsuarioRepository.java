package com.brainstorm.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.brainstorm.model.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("select s from Usuario s where s.email = :email")
	List<Usuario> findByEmail(@Param("email") String email);
    
}



