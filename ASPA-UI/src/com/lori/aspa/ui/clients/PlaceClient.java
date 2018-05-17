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
import com.lori.aspa.ui.models.PlaceDTO;

public class PlaceClient {
	
	
	public PlaceDTO findPlaceById(Integer id) {
		final String BASE_URL = IApiClient.SERVER+"/api/place/findById/"+id;
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);

		ResponseEntity<PlaceDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, PlaceDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}

	public List<PlaceDTO> loadPlaces() {
		final String BASE_URL = IApiClient.SERVER+"/api/place/loadAll";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<PlaceDTO>> typeRef = new ParameterizedTypeReference<List<PlaceDTO>>() {};
		
		ResponseEntity<List<PlaceDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}

}
