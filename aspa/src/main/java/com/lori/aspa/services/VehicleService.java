
package com.lori.aspa.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lori.aspa.api.req.VehicleReq;
import com.lori.aspa.assemblers.Assembler;
import com.lori.aspa.assemblers.RequestAssembler;
import com.lori.aspa.constants.IDecision;
import com.lori.aspa.constants.IStatus;
import com.lori.aspa.dao.AuthorizationDAO;
import com.lori.aspa.dao.VehicleDAO;
import com.lori.aspa.dao.sql.AuthorizationSQL;
import com.lori.aspa.dao.sql.VehicleSQL;
import com.lori.aspa.dto.VehicleDTO;
import com.lori.aspa.entities.Authorization;
import com.lori.aspa.entities.Vehicle;
import com.lori.aspa.exceptions.AppException;
import com.lori.aspa.exceptions.EntityExistsException;

@Service
public class VehicleService {

	
	@Autowired
	VehicleDAO vehicleDAO;
	@Autowired
	AuthorizationDAO authorizationDAO;
	
	public VehicleDTO findVehicleById(Integer id)
	{
		return new Assembler().toDto(vehicleDAO.findById(id));
	}
	
	
	public List<VehicleDTO> searchVehicle(VehicleReq req)
	{
		VehicleSQL sql = new RequestAssembler().toSql(req);
		
		return new Assembler().vehicleListToDto(vehicleDAO.search(sql));
	}
	
	
	public VehicleDTO isAvailable(Integer vehicleId, Date from, Date to, Integer authId) throws AppException
	{
		
		Vehicle v = vehicleDAO.findById(vehicleId);
		AuthorizationSQL authSql = new AuthorizationSQL();
		authSql.setFromDate(from);
		authSql.setToDate(to);
		authSql.setStatus(IStatus.ACTIVE);
		authSql.setNotDecision(IDecision.DENY);
		authSql.setVehicleId(vehicleId);

		List<Authorization> listAuth =  authorizationDAO.search(authSql);
		
		if(listAuth == null || listAuth.isEmpty())
		{
			return new Assembler().toDto(v);
		}
		if(authId == null || (authId == listAuth.get(0).getId()))
		{
			return new Assembler().toDto(v);
		}
		
		throw new EntityExistsException("Automjeti "+v.getPlate()+" është i planifikuar me shërbim drejt "+listAuth.get(0).getToPlace().getName());
		
		
		
		
	}
	
	
}
