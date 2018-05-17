package com.lori.aspa.ui.services;

import java.util.List;

import com.lori.aspa.ui.clients.PlaceClient;
import com.lori.aspa.ui.models.PlaceDTO;

public class PlaceService {
	

	public PlaceDTO findPlaceById(Integer id) {
		return new PlaceClient().findPlaceById(id);
	}

	public List<PlaceDTO> loadPlaces() {
		return new PlaceClient().loadPlaces();
	}

}
