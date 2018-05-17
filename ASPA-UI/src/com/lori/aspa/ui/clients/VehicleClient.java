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
import com.lori.aspa.ui.criterias.VehicleReq;
import com.lori.aspa.ui.models.VehicleDTO;

public class VehicleClient {
	
	
	public VehicleDTO findVehicleById(Integer id) {
		
		final String BASE_URL = IApiClient.SERVER+"/api/vehicle/findById/"+id;
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		
		ResponseEntity<VehicleDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, VehicleDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}

	public List<VehicleDTO> getUserVehicles(String token) {
		final String BASE_URL = IApiClient.SERVER+"/api/vehicle/getUserVehicles";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<VehicleDTO>> typeRef = new ParameterizedTypeReference<List<VehicleDTO>>() {};
		
		ResponseEntity<List<VehicleDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}

	public VehicleDTO registerVehicle(VehicleDTO vehicle, String token) {

		return null;
	}

	public VehicleDTO modifyVehicle(VehicleDTO vehicle, String token) {
		return null;
	}

	public VehicleDTO deleteVehicle(VehicleDTO vehicle, String token) {
		return null;
	}

	public List<VehicleDTO> searchVehicles(VehicleReq req, String token) {
		return null;
	}
	
	

}
