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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import com.brainstorm.model.Tarea;
import com.brainstorm.repository.TareasRepository;
import com.brainstorm.service.TareaService;
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
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.http.HttpStatus;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
class TareaControllerTest {
	
    @InjectMocks
    private TareaController tareaController;

    @Mock
    private TareaService tareaService;

    @Test
    public void givenTareas_whenGetTareas_thenReturnJsonArray()
      throws Exception {
    	
    	Tarea tarea=new Tarea();
    	tarea.setDescripcion("Test");
    	tareaController.create(tarea);
    	
    	Mockito.when(tareaService.save(tarea)).thenReturn(tarea);
    	
    	assertNotNull(tareaController.create(tarea));
    	assertEquals(tarea.getDescripcion(),"Test");
    	
    	
    }

}