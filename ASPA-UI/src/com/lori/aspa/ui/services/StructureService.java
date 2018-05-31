package com.lori.aspa.ui.services;

import java.util.List;

import com.lori.aspa.ui.clients.StructureClient;
import com.lori.aspa.ui.models.StructureDTO;

public class StructureService {
	

	public List<StructureDTO> getUserStructures(String token) {
		return new StructureClient().getUserStructures(token);
	}

	public StructureDTO registerStructure(StructureDTO str, String token) {
		return new StructureClient().registerStructure(str, token);
	}

	public StructureDTO modifyStructure(StructureDTO str, String token) {
		return new StructureClient().modifyStructure(str, token);
	}

	
	public StructureDTO deleteStructure(StructureDTO str, String token) {
		return new StructureClient().deleteStructure(str, token);
	}
	
	public List<StructureDTO> loadStructures()
	{
		return new StructureClient().loadStructures();
	}

}
