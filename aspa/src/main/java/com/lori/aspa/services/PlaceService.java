package com.lori.aspa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lori.aspa.assemblers.Assembler;
import com.lori.aspa.dao.PlaceDAO;
import com.lori.aspa.dao.sql.PlaceSQL;
import com.lori.aspa.dto.PlaceDTO;

@Service
public class PlaceService {
	
	@Autowired
	PlaceDAO placeDAO;
	
	
	public PlaceDTO findPlaceById(Integer id) 
	{
		return new Assembler().toDto(placeDAO.findById(id));
	}
	
	public List<PlaceDTO> loadPlaces() 
	{
		return new Assembler().placeListToDto(placeDAO.search(new PlaceSQL()));
	}
	

}
