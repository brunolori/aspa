package com.lori.aspa.ui.clients;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.lori.aspa.ui.constants.IApiClient;
import com.lori.aspa.ui.models.StructureDTO;

public class StructureClient {
	
	
	public List<StructureDTO> getUserStructures(String token) {
		final String BASE_URL = IApiClient.SERVER+"/api/structure/userStructures/"+0;
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);

		ParameterizedTypeReference<List<StructureDTO>> typeRef = new ParameterizedTypeReference<List<StructureDTO>>() {};
		
		ResponseEntity<List<StructureDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}

	public StructureDTO registerStructure(StructureDTO str, String token) 	{
		
		final String BASE_URL = IApiClient.SERVER+"/api/structure/register";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<StructureDTO>(str,headers);
		
		ResponseEntity<StructureDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, StructureDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}

	public StructureDTO modifyStructure(StructureDTO str, String token) {
		
        final String BASE_URL = IApiClient.SERVER+"/api/structure/modify";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<StructureDTO>(str,headers);
		
		ResponseEntity<StructureDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, StructureDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}

	public StructureDTO deleteStructure(StructureDTO str, String token) {
		
		final String BASE_URL = IApiClient.SERVER+"/api/structure/delete";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<StructureDTO>(str,headers);
		
		ResponseEntity<StructureDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, StructureDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}		
		return null;
	}

	public List<StructureDTO> loadStructures() {
		
		final String BASE_URL = IApiClient.SERVER+"/api/structure/loadStructures";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<StructureDTO>> typeRef = new ParameterizedTypeReference<List<StructureDTO>>() {};
		
		ResponseEntity<List<StructureDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}

}
