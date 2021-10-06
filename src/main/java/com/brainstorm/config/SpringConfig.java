package com.brainstorm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.brainstorm.model.Tarea;
import com.brainstorm.repository.TareasRepository;
import com.brainstorm.service.TareaService;
import com.brainstorm.service.TareaServiceImpl;

@Configuration
@EnableJpaRepositories
public class SpringConfig {

	@Bean
	public TareaService tareaService() {

		return new TareaServiceImpl();
	}
	
	
}