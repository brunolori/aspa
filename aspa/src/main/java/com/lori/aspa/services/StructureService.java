package com.lori.aspa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lori.aspa.assemblers.Assembler;
import com.lori.aspa.constants.IStatus;
import com.lori.aspa.dao.StructureDAO;
import com.lori.aspa.dto.StructureDTO;

@Service
public class StructureService {

	@Autowired
	StructureDAO structureDAO;
	
	public StructureDTO findStructureById(Integer structureId)
	{
		return new Assembler().toDto(structureDAO.findById(structureId));
	}
	
	public List<StructureDTO> getStructureChilds(Integer structureId)
	{
		
			List<StructureDTO> strs = new ArrayList<>();
			
			List<StructureDTO> childs = new Assembler().structureListToDto(structureDAO.search(null, structureId, IStatus.ACTIVE, null, null));
			if(childs != null && !childs.isEmpty())
			{
				for(StructureDTO s : childs)
				{
					strs.add(s);
					strs.addAll(getStructureChilds(s.getId()));
				}
				
			}
			
			return strs;
			
	}
	
	
	
}
