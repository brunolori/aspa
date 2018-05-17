package com.lori.aspa.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lori.aspa.assemblers.Assembler;
import com.lori.aspa.constants.IDecision;
import com.lori.aspa.constants.IStatus;
import com.lori.aspa.dao.AuthorizationDAO;
import com.lori.aspa.dao.OfficerDAO;
import com.lori.aspa.dao.sql.AuthorizationSQL;
import com.lori.aspa.dao.sql.OfficerSQL;
import com.lori.aspa.dto.OfficerDTO;
import com.lori.aspa.dto.StructureDTO;
import com.lori.aspa.entities.Authorization;
import com.lori.aspa.entities.Officer;
import com.lori.aspa.exceptions.EntityExistsException;

@Service
public class OfficerService {

	@Autowired
	OfficerDAO officerDAO;
	@Autowired 
	StructureService structureService;
	@Autowired
	AuthorizationDAO authorizationDAO;
	
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
	
	public OfficerDTO isAvailable(Integer officerId,Date from, Date to) throws EntityExistsException
	{
		
		Officer o = officerDAO.findById(officerId);
		AuthorizationSQL authSql = new AuthorizationSQL();
		authSql.setFromDate(from);
		authSql.setToDate(to);
		authSql.setStatus(IStatus.ACTIVE);
		authSql.setNotDecision(IDecision.DENY);
		authSql.setOfficerId(officerId);

		List<Authorization> listAuth =  authorizationDAO.search(authSql);
		
		if(listAuth == null || listAuth.isEmpty())
		{
			return new Assembler().toDto(o);
		}
		
		throw new EntityExistsException(o.getName()+" "+o.getSurname()+" është i planifikuar me shërbim drejt "+listAuth.get(0).getToPlace().getName());
		
		
	}
	
	
}
