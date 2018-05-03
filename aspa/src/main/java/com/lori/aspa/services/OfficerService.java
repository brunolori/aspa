package com.lori.aspa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lori.aspa.assemblers.Assembler;
import com.lori.aspa.constants.IStatus;
import com.lori.aspa.dao.OfficerDAO;
import com.lori.aspa.dao.sql.OfficerSQL;
import com.lori.aspa.dto.OfficerDTO;
import com.lori.aspa.dto.StructureDTO;

@Service
public class OfficerService {

	@Autowired
	OfficerDAO officerDAO;
	@Autowired 
	StructureService structureService;
	
	public List<OfficerDTO> getStructureOfficers(Integer structureId)
	{
		List<StructureDTO> strs = structureService.getStructureChilds(structureId);
		if(strs == null) strs = new ArrayList<>();
		strs.add(structureService.findStructureById(structureId));
		
		List<Integer> stdIds = new ArrayList<>();
		
		for(StructureDTO d : strs)
		{
			stdIds.add(d.getId());
		}
		
		
		
		OfficerSQL criterias = new OfficerSQL();
		criterias.setStructuresIdList(stdIds);
		criterias.setStatus(IStatus.ACTIVE);
		
		return new Assembler().officerListToDto(officerDAO.search(criterias));
		
	}
	
	
	
	
	
}
