package com.brainstorm.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

@ActiveProfiles("test")
@SpringBootTest
class RestTemplateTest {
	
	@Mock
	private RestTemplate restTemplate;
	
	
	String json="{\r\n"
			+ "    \"descripcion\":\"Prueba Security\",\r\n"
			+ "    \"responsable\":3,\r\n"
			+ "    \"status\":1,\r\n"
			+ "    \"fechaComprometida\":\"2021-12-10\",\r\n"
			+ "    \"puntaje\":3,\r\n"
			+ "    \"prioridad\":1,\r\n"
			+ "    \"iconoId\":2\r\n"
			+ "}";
	
	HttpHeaders headers=new HttpHeaders();
	ResponseEntity<String> response=new ResponseEntity<String>(HttpStatus.OK);	
	HttpEntity<String> request =new HttpEntity<String>(json,headers);

	@Test
	void testCall() {
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		Mockito.when(restTemplate.postForEntity("http://localhost:8080/tareas", request, String.class)).thenReturn(response);
		assertEquals(200,response.getStatusCodeValue());
		
	}


}
