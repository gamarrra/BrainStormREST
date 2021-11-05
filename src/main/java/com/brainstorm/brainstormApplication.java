package com.brainstorm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.brainstorm.model.Grupo;
import com.brainstorm.model.Tarea;
import com.brainstorm.model.Usuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@EnableJpaAuditing
public class brainstormApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(brainstormApplication.class, args);
		Grupo grupo=new Grupo();
		Usuario user=new Usuario();
		Tarea tarea=new Tarea();
		ObjectMapper mapper = new ObjectMapper();
		
		  String json = mapper.writeValueAsString(grupo);
		  System.out.println("ResultingJSONstring = " + json);
		  
		  String json2 = mapper.writeValueAsString(user);
		  System.out.println("ResultingJSONstring = " + json2);
		  
		  String json23 = mapper.writeValueAsString(tarea);
		  System.out.println("ResultingJSONstring = " + json23);
	}
}
