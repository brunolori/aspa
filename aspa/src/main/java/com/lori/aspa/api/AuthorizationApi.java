package com.lori.aspa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lori.aspa.dto.AuthorizationDTO;
import com.lori.aspa.services.AuthorizationService;

@RestController
@RequestMapping("/api/authorization")
public class AuthorizationApi {
	
	
	@Autowired
	AuthorizationService authorizationService;
	
	
	@RequestMapping(value="/findAuthorization/{id}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<?> findAuthorization(@PathVariable(name="id") Integer authorizationId)
	{
		AuthorizationDTO auth = authorizationService.findAuthorizationById(authorizationId);
		return new ResponseEntity<>(auth,HttpStatus.OK);
	}
	
	
	
	

}
