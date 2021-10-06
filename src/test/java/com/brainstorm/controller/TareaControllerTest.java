package com.brainstorm.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.brainstorm.config.SpringConfig;
import com.brainstorm.model.Tarea;
import com.brainstorm.repository.TareasRepository;
import com.brainstorm.service.TareaServiceImpl;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.http.HttpStatus;


@RunWith(SpringRunner.class)
@WebMvcTest(TareaController.class)
@AutoConfigureMockMvc
class TareaControllerTest {

    @Autowired
    private MockMvc mvc;
    
    @Autowired
    private TareaServiceImpl tareaService;
    
    @Autowired
    private TareasRepository tareaRepository;
    
    @Test
    public void givenTareas_whenGetTareas_thenReturnJsonArray()
      throws Exception {
        
        Tarea tarea1 = new Tarea();
        tarea1.setDescripcion("test");

        List<Tarea> allTareas = Arrays.asList(tarea1);
        
        tareaRepository.save(tarea1);

        given(tareaService.getAll()).willReturn(allTareas);

        mvc.perform(get("/tareas")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$", hasSize(1)))
          .andExpect(jsonPath("$[0].descripcion", is(tarea1.getDescripcion())));
    }

    @Test
    public void whenPostTarea_thenCreateTarea() throws Exception {

    	Tarea tarea1 = new Tarea();
    	
    	tarea1.setDescripcion("Prueba Security");
    	tarea1.setResponsable(3L);
    	tarea1.setStatusId(1);
    	tarea1.setFechaComprometida(new Date(2021-12-10));
    	tarea1.setPuntaje(3);
    	tarea1.setPrioridad(1);
    	tarea1.setIconoId(2);
    	
        tareaRepository.save(tarea1);
    	
        given(tareaService.save(Mockito.any())).willReturn(tarea1);

        mvc.perform(post("/tareas").contentType(MediaType.APPLICATION_JSON).content("{\r\n"
        		+ "    \"descripcion\":\"Prueba Security\",\r\n"
        		+ "    \"responsable\":3,\r\n"
        		+ "    \"status\":1,\r\n"
        		+ "    \"fechaComprometida\":\"2021-12-10\",\r\n"
        		+ "    \"puntaje\":3,\r\n"
        		+ "    \"prioridad\":1,\r\n"
        		+ "    \"iconoId\":2\r\n"
        		+ "}")).andExpect(status().isCreated()).andExpect(jsonPath("$.descripcion", is("Prueba Security")));
        verify(tareaService, VerificationModeFactory.times(1)).save(Mockito.any());
        reset(tareaService);
    }

	@Test
	void testGetById() throws Exception {
        String response = mvc.perform(get("http://localhost:8080/tareas", 1))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.descripcion", is("Crear Entidades")))
                .andReturn().getResponse().getContentAsString();
 
        assertNotNull(response);
	}

	@Test
	void testDelete() throws Exception {
        String response = mvc.perform(delete("http://localhost:8080/tareas", 1))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse().getContentAsString();
 
        assertNotNull(response);
	}

}