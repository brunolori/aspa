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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lori.aspa.ui.constants.IApiClient;
import com.lori.aspa.ui.criterias.AuthorizationReq;
import com.lori.aspa.ui.models.ApprovalHistoryDTO;
import com.lori.aspa.ui.models.AuthorizationDTO;
import com.lori.aspa.ui.models.MyDashboardDTO;

public class AuthClient {

	
	public AuthorizationDTO getAuthorizationById(Integer authId)
	{
		try {
		final String BASE_URL = IApiClient.SERVER+"/api/authorization/findAuthorization/"+authId;
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);

		//ResponseEntity<AuthorizationDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, AuthorizationDTO.class);
		ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
		

		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			ObjectMapper objectMapper = new ObjectMapper();
			AuthorizationDTO auth = objectMapper.readValue(response.getBody(), AuthorizationDTO.class);
			return auth;
		}	
		if(response.getStatusCode() == HttpStatus.NOT_FOUND)
		{
			System.out.println(response.getBody());
			return null;
		}	
		else
		{
			System.err.println("BODYYY: "+response.getBody());
			return null;
		}
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	
	public AuthorizationDTO registerAuthorization(AuthorizationDTO auth, String token)
	{
		
		final String BASE_URL = IApiClient.SERVER+"/api/authorization/register";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<AuthorizationDTO>(auth,headers);
		
		ResponseEntity<AuthorizationDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, AuthorizationDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	
	public AuthorizationDTO modifyAuthorization(AuthorizationDTO auth, String token)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/authorization/modify";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<AuthorizationDTO>(auth,headers);
		
		ResponseEntity<AuthorizationDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, AuthorizationDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	
	public AuthorizationDTO deleteAuthorization(AuthorizationDTO auth, String token)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/authorization/delete";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<AuthorizationDTO>(auth,headers);
		
		ResponseEntity<AuthorizationDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, AuthorizationDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	
	public List<AuthorizationDTO> searchAuthorization(AuthorizationReq req,String token)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/authorization/searchAuthorization";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<AuthorizationReq>(req,headers);
		
		ParameterizedTypeReference<List<AuthorizationDTO>> typeRef = new ParameterizedTypeReference<List<AuthorizationDTO>>() {};
		
		ResponseEntity<List<AuthorizationDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	
	
	
	public MyDashboardDTO getMyDashboard(String token)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/authorization/myDashboard";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);

		ResponseEntity<MyDashboardDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, MyDashboardDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	
	public void decide(ApprovalHistoryDTO history, String token)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/authorization/decide";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<ApprovalHistoryDTO>(history,headers);
		
		ResponseEntity<AuthorizationDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, AuthorizationDTO.class);
		
		if(response.getStatusCode() != HttpStatus.OK)
		{
			throw new RuntimeException("Error.."+response.getStatusCode());
		}				
		
	}
	
	
	
	public List<AuthorizationDTO> getAuthsToVerify(String token)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/authorization/getAuthorizationsToVerify";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<AuthorizationDTO>> typeRef = new ParameterizedTypeReference<List<AuthorizationDTO>>() {};
		
		ResponseEntity<List<AuthorizationDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;	
	}
	
	
	public List<AuthorizationDTO> getVerifiedAuths(String token)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/authorization/getVerifiedAuths";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<AuthorizationDTO>> typeRef = new ParameterizedTypeReference<List<AuthorizationDTO>>() {};
		
		ResponseEntity<List<AuthorizationDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;	
	}
	
	
	public List<ApprovalHistoryDTO> getAuthHistory(AuthorizationDTO auth, String token)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/authorization/getAuthHistory/"+auth.getId();
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<ApprovalHistoryDTO>> typeRef = new ParameterizedTypeReference<List<ApprovalHistoryDTO>>() {};
		
		ResponseEntity<List<ApprovalHistoryDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;	
	}
	
	
	
	
	
	
	
	
}
