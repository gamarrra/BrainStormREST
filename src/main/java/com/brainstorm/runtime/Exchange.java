package com.brainstorm.runtime;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Exchange {
	
	RestTemplate restTemplate =new RestTemplate();
	
	public String[] call(String json){
		
		HttpHeaders headers=new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> request =new HttpEntity<String>(json,headers);
		
		ResponseEntity<String> response=null;
		
		 String[] output=new String[2];
		 try {
			 response=restTemplate.postForEntity("http://localhost:8080/tareas", request, String.class);
			 output[0]=String.valueOf(response.getStatusCodeValue());
			 output[1]=String.valueOf(response.getBody());
		 }catch (Exception e) {}
		 return output;
		
		
	}

}
