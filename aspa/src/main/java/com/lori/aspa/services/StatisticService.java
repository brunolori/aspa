package com.lori.aspa.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lori.aspa.dao.StatisticDAO;
import com.lori.aspa.dto.StructureDTO;
import com.lori.aspa.dto.UserDTO;
import com.lori.aspa.model.OfficerCount;
import com.lori.aspa.model.ValuePair;


@Service
public class StatisticService {
	
	
	@Autowired
	StatisticDAO statisticDAO;
	@Autowired
	StructureService structureService;
	@Autowired UserService userService;
	
	
	public long countAllAuths(Date fromDate, Date toDate, String decision, Integer structureId, String uname) {
		
		List<Integer> strs = new ArrayList<>();
		if(structureId != null) strs.add(structureId);
		else
		{
			UserDTO u = userService.findUserByUsername(uname);
			List<StructureDTO> dto = structureService.getStructureChilds(u.getOfficer().getStructureId());
			if(dto == null) dto = new ArrayList<>();
			for(StructureDTO s : dto)
			{
				strs.add(s.getId());
			}
			strs.add(u.getId());
		}
		
		return statisticDAO.countAllAuths(fromDate, toDate, decision, strs);
	}
	
	
	public long countActiveServices(Integer structureId, String uname)
	{
		List<Integer> strs = new ArrayList<>();
		if(structureId != null) strs.add(structureId);
		else
		{
			UserDTO u = userService.findUserByUsername(uname);
			List<StructureDTO> dto = structureService.getStructureChilds(u.getOfficer().getStructureId());
			if(dto == null) dto = new ArrayList<>();
			for(StructureDTO s : dto)
			{
				strs.add(s.getId());
			}
			strs.add(u.getId());
		}
		
		return statisticDAO.countActiveServices(strs);
	}
	
	public long countOfficersInService(Integer structureId, String uname)
	{
		List<Integer> strs = new ArrayList<>();
		if(structureId != null) strs.add(structureId);
		else
		{
			UserDTO u = userService.findUserByUsername(uname);
			List<StructureDTO> dto = structureService.getStructureChilds(u.getOfficer().getStructureId());
			if(dto == null) dto = new ArrayList<>();
			for(StructureDTO s : dto)
			{
				strs.add(s.getId());
			}
			strs.add(u.getId());
		}
		
		return statisticDAO.countOfficersInService(strs);
	}
	
	public long countVehiclesInService(Integer structureId, String uname)
	{
		List<Integer> strs = new ArrayList<>();
		if(structureId != null) strs.add(structureId);
		else
		{
			UserDTO u = userService.findUserByUsername(uname);
			List<StructureDTO> dto = structureService.getStructureChilds(u.getOfficer().getStructureId());
			if(dto == null) dto = new ArrayList<>();
			for(StructureDTO s : dto)
			{
				strs.add(s.getId());
			}
			strs.add(u.getId());
		}
		
		return statisticDAO.countVehiclesInService(strs);
	}
	
	
	public List<ValuePair> getOfficersInServiceByDate(Date fromDate, Date toDate,Integer structureId, String uname)
	{
		List<Integer> strs = new ArrayList<>();
		if(structureId != null) strs.add(structureId);
		else
		{
			UserDTO u = userService.findUserByUsername(uname);
			List<StructureDTO> dto = structureService.getStructureChilds(u.getOfficer().getStructureId());
			if(dto == null) dto = new ArrayList<>();
			for(StructureDTO s : dto)
			{
				strs.add(s.getId());
			}
			strs.add(u.getId());
		}
		
		return statisticDAO.getOfficersInServiceByDate(fromDate, toDate, strs);
	}
	
	public List<ValuePair> countAuthorizationsByMonth(Integer year, Integer structureId, String uname)
	{
		List<Integer> strs = new ArrayList<>();
		if(structureId != null) strs.add(structureId);
		else
		{
			UserDTO u = userService.findUserByUsername(uname);
			List<StructureDTO> dto = structureService.getStructureChilds(u.getOfficer().getStructureId());
			if(dto == null) dto = new ArrayList<>();
			for(StructureDTO s : dto)
			{
				strs.add(s.getId());
			}
			strs.add(u.getId());
		}
		
		return statisticDAO.countAuthorizationsByMonth(year, strs);
		
	}
	
	public List<OfficerCount> getOfficersByServiceNo(Date fromDate, Date toDate,Integer structureId, String uname)
	{
		List<Integer> strs = new ArrayList<>();
		if(structureId != null) strs.add(structureId);
		else
		{
			UserDTO u = userService.findUserByUsername(uname);
			List<StructureDTO> dto = structureService.getStructureChilds(u.getOfficer().getStructureId());
			if(dto == null) dto = new ArrayList<>();
			for(StructureDTO s : dto)
			{
				strs.add(s.getId());
			}
			strs.add(u.getId());
		}
		
	  	return statisticDAO.getOfficersByServiceNo(fromDate, toDate, strs);
		
	}
	

}
