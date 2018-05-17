package com.lori.aspa.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lori.aspa.dto.PlaceDTO;
import com.lori.aspa.services.PlaceService;

@RestController
@RequestMapping("/api/place")
public class PlaceApi {
	
	
	@Autowired
	PlaceService placeService;
	
	
	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> findUserById(@PathVariable(name = "id") Integer id) {
		PlaceDTO p = placeService.findPlaceById(id);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/loadAll", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> loadPlaces()
	{
		List<PlaceDTO> p = placeService.loadPlaces();
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	
	
	

}
