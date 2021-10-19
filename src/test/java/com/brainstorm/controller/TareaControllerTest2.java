package com.brainstorm.controller;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;

import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.brainstorm.model.Tarea;

import com.brainstorm.service.TareaService;
import com.fasterxml.jackson.databind.ObjectMapper;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.mockito.InjectMocks;
import org.mockito.Mockito;


@WebMvcTest(TareaController.class)
@ContextConfiguration(classes = {TareaController.class})
public class TareaControllerTest2 {
	
    @Autowired
    MockMvc mockMvc;
    
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    TareaService tareaService;
    
    @InjectMocks
    Tarea tarea;


	    @Test
	    public void getTareasUnauthorized() throws Exception {
	    	
	    	Tarea tarea=new Tarea();
	    	tarea.setDescripcion("Test");
	    	Tarea tarea2=new Tarea();
	    	Tarea tarea3=new Tarea();
	    	
	        List<Tarea> tareas = new ArrayList<>(Arrays.asList(tarea, tarea2, tarea3));
	        
	        Mockito.when(tareaService.getAll()).thenReturn(tareas);
	        
	        mockMvc.perform(MockMvcRequestBuilders
	                .get("/tareas")
	                .contentType(MediaType.APPLICATION_JSON))
            		.andExpect(status().isUnauthorized());
	    }
	    
	    @Test
	    public void getTareaByIdUnauthorized () throws Exception {
	    	
	    	Tarea tarea=new Tarea();
	    	tarea.setTareaId(1L);
	    	
	        Mockito.when(tareaService.getById(tarea.getTareaId())).thenReturn(java.util.Optional.of(tarea));

	        mockMvc.perform(MockMvcRequestBuilders
	                .get("/tareas/")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isUnauthorized());
	    }
	    
	    @Test
	    public void createTarea_Forbidden() throws Exception {
	    	Tarea tarea=new Tarea();

	        Mockito.when(tareaService.save(tarea)).thenReturn(tarea);

	        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/tarea")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON)
	                .content(this.mapper.writeValueAsString(tarea));

	        mockMvc.perform(mockRequest)
	                .andExpect(status().isForbidden());
	        }
	    
	    @Test
	    public void updateTareaRecord_Forbidden() throws Exception {
	    	
	    	Tarea tarea=new Tarea();
	    	tarea.setTareaId(1L);
	    	
	    	Mockito.when(tareaService.getById(tarea.getTareaId())).thenReturn(java.util.Optional.of(tarea));

	        Mockito.when(tareaService.save(tarea)).thenReturn(tarea);

	        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/tarea")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON)
	                .content(this.mapper.writeValueAsString(tarea));

	        mockMvc.perform(mockRequest)
	                .andExpect(status().isForbidden());
	    }
	}



