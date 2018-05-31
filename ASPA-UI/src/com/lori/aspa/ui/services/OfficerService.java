package com.lori.aspa.ui.services;

import java.util.List;

import com.lori.aspa.ui.clients.OfficerClient;
import com.lori.aspa.ui.models.OfficerDTO;

public class OfficerService {

	
	public OfficerDTO findOfficerById(Integer id) {
		return new OfficerClient().findOfficerById(id);
	}

	public List<OfficerDTO> queryOfficer(String nameSurname) {
		return new OfficerClient().queryOfficer(nameSurname);
	}
	
	public List<OfficerDTO> searchOfficer(String name,String surname) {
		return new OfficerClient().searchOfficer(name, surname);
	}
	
}
