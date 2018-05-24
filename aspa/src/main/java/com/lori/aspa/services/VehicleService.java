
package com.lori.aspa.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lori.aspa.annotations.AppTransactional;
import com.lori.aspa.api.req.VehicleReq;
import com.lori.aspa.assemblers.Assembler;
import com.lori.aspa.assemblers.RequestAssembler;
import com.lori.aspa.constants.IDecision;
import com.lori.aspa.constants.IStatus;
import com.lori.aspa.dao.AuthorizationDAO;
import com.lori.aspa.dao.StructureDAO;
import com.lori.aspa.dao.UserDAO;
import com.lori.aspa.dao.VehicleDAO;
import com.lori.aspa.dao.sql.AuthorizationSQL;
import com.lori.aspa.dao.sql.VehicleSQL;
import com.lori.aspa.dto.VehicleDTO;
import com.lori.aspa.dto.VehicleTypeDTO;
import com.lori.aspa.entities.Authorization;
import com.lori.aspa.entities.Structure;
import com.lori.aspa.entities.User;
import com.lori.aspa.entities.Vehicle;
import com.lori.aspa.entities.VehicleType;
import com.lori.aspa.exceptions.AppException;
import com.lori.aspa.exceptions.EmptyFieldsException;
import com.lori.aspa.exceptions.EntityExistsException;

@Service
public class VehicleService {

	@Autowired
	VehicleDAO vehicleDAO;
	@Autowired
	AuthorizationDAO authorizationDAO;
	@Autowired
	UserDAO userDAO;
	@Autowired
	StructureDAO structureDAO;

	public VehicleDTO findVehicleById(Integer id) {
		return new Assembler().toDto(vehicleDAO.findById(id));
	}
	
	

	public List<VehicleDTO> searchVehicle(VehicleReq req) {
		VehicleSQL sql = new RequestAssembler().toSql(req);

		return new Assembler().vehicleListToDto(vehicleDAO.search(sql));
	}

	public VehicleDTO isAvailable(Integer vehicleId, Date from, Date to, Integer authId) throws AppException {

		Vehicle v = vehicleDAO.findById(vehicleId);

		AuthorizationSQL authSql = new AuthorizationSQL();
		authSql.setFromDate(from);
		authSql.setToDate(to);
		authSql.setStatus(IStatus.ACTIVE);
		authSql.setNotDecision(IDecision.DENY);
		authSql.setVehicleId(vehicleId);

		List<Authorization> listAuth = authorizationDAO.search(authSql);

		if (listAuth == null || listAuth.isEmpty()) {
			return new Assembler().toDto(v);
		}
		if (authId == null || (authId == listAuth.get(0).getId())) {
			return new Assembler().toDto(v);
		}

		throw new EntityExistsException("Automjeti " + v.getPlate() + " është i planifikuar me shërbim drejt "
				+ listAuth.get(0).getToPlace().getName());

	}

	public List<VehicleTypeDTO> loadVehicleTypes() {
		return new Assembler().vehicleTypeListToDto(vehicleDAO.loadVehicleTypes());
	}

	@AppTransactional
	public VehicleDTO registerVehicle(VehicleDTO dto, String uname) throws AppException {

		if (dto.getPlate() == null) {

			throw new EmptyFieldsException("Targa e papërcaktuar ");
		}

		if (dto.getTypeCode() == null) {

			throw new EmptyFieldsException("Lloji automjetit i papërcaktuar ");
		}

		if (dto.getStructureId() <= 0) {

			throw new EmptyFieldsException("Struktura e papërcaktuar ");
		}

		User u = userDAO.findByUsername(uname);
		Structure structure = structureDAO.findById(dto.getStructureId());
		VehicleType type = vehicleDAO.getVehicleTypeByTag(dto.getTypeCode());
		
		
		
		Vehicle v = new Vehicle();

		v.setPlate(dto.getPlate());
		v.setCapacity(dto.getCapacity());
		v.setCarriage(1);
		v.setCreateTime(Calendar.getInstance().getTime());
		v.setDescription(dto.getDescription());
		v.setStructure(structure);
		v.setType(type);
		v.setStatus(IStatus.ACTIVE);
		v.setCreateUser(u);

		v = vehicleDAO.create(v);

		return new Assembler().toDto(v);

	}

	@AppTransactional
	public VehicleDTO modifyVehicle(VehicleDTO dto, String uname) throws AppException {

		if (dto.getPlate() == null) {

			throw new EmptyFieldsException("Targa e papërcaktuar ");
		}

		if (dto.getTypeCode() == null) {

			throw new EmptyFieldsException("Lloji automjetit i papërcaktuar ");
		}

		if (dto.getStructureId() <= 0) {

			throw new EmptyFieldsException("Struktura e papërcaktuar ");
		}

		User u = userDAO.findByUsername(uname);
		Structure structure = structureDAO.findById(dto.getStructureId());
		VehicleType type = vehicleDAO.getVehicleTypeByTag(dto.getTypeCode());
		
		
		Vehicle v = vehicleDAO.findById(dto.getId());

		v.setPlate(dto.getPlate());
		v.setCapacity(dto.getCapacity());
		v.setCarriage(1);
		v.setDescription(dto.getDescription());
		v.setStructure(structure);
		v.setType(type);
		v.setUpdateTime(Calendar.getInstance().getTime());
		v.setUpdateUser(u);
		
		

		v = vehicleDAO.update(v);

		return new Assembler().toDto(v);

	}

}
