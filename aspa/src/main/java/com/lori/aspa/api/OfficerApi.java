package com.lori.aspa.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lori.aspa.dto.OfficerDTO;
import com.lori.aspa.services.OfficerService;


@RestController
@RequestMapping("/api/officer")
public class OfficerApi {
	
	
	@Autowired
	OfficerService officerService;
	
	@RequestMapping(value = "/findOfficerById/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> findOfficerById(@PathVariable(name = "id") Integer officerId) {
		OfficerDTO off = officerService.findOfficerById(officerId);
		return new ResponseEntity<>(off, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/queryOfficer", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> queryUser(@RequestParam(name = "query") String query) {
		List<OfficerDTO> o = officerService.queryOfficer(query);
		return new ResponseEntity<>(o, HttpStatus.OK);
	}
	

}
