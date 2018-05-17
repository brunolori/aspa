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
import com.lori.aspa.ui.models.Principal;
import com.lori.aspa.ui.models.UserDTO;
import com.lori.aspa.ui.models.UserTokenDTO;

public class UserClient {
	
	public UserDTO findUserById(Integer id) {
		final String BASE_URL = IApiClient.SERVER+"/api/user/findById/"+id;
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);

		ResponseEntity<UserDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, UserDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}

	public UserDTO registerUser(UserDTO user, String token) {
		return null;
	}

	public UserDTO modifyUser(UserDTO user, String token) {
		return null;
	}

	public UserDTO deleteUser(UserDTO user, String token) {
		return null;
	}

	public List<UserDTO> searchUser(String token) {
		return null;
	}

	public List<UserDTO> queryUser(String nameSurname) {
		final String BASE_URL = IApiClient.SERVER+"/api/user/queryUser";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		builder.queryParam("query", nameSurname);
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<UserDTO>> typeRef = new ParameterizedTypeReference<List<UserDTO>>() {};
		
		ResponseEntity<List<UserDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}

	public UserTokenDTO login(Principal principal) {
		final String BASE_URL = IApiClient.SERVER+"/api/user/login";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<Principal>(principal,headers);
		
		ResponseEntity<UserTokenDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, UserTokenDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}

	
	public static void main(String args[])
	{
		UserClient c = new UserClient();
		Principal p = new Principal();
		p.setPassword("1234");
		p.setUsername("bruno");
		c.login(p);
	}
	
	
}
