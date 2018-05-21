package com.lori.aspa.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lori.aspa.annotations.AppTransactional;
import com.lori.aspa.api.req.AuthorizationReq;
import com.lori.aspa.assemblers.Assembler;
import com.lori.aspa.assemblers.RequestAssembler;
import com.lori.aspa.constants.IDecision;
import com.lori.aspa.constants.IStatus;
import com.lori.aspa.dao.AuthorizationDAO;
import com.lori.aspa.dao.HistoryDAO;
import com.lori.aspa.dao.PlaceDAO;
import com.lori.aspa.dao.StructureDAO;
import com.lori.aspa.dao.UserDAO;
import com.lori.aspa.dao.sql.AuthorizationSQL;
import com.lori.aspa.dto.ApprovalHistoryDTO;
import com.lori.aspa.dto.AuthorizationDTO;
import com.lori.aspa.dto.OfficerDTO;
import com.lori.aspa.dto.VehicleDTO;
import com.lori.aspa.entities.ApprovalHistory;
import com.lori.aspa.entities.Authorization;
import com.lori.aspa.entities.Officer;
import com.lori.aspa.entities.Place;
import com.lori.aspa.entities.Structure;
import com.lori.aspa.entities.User;
import com.lori.aspa.entities.Vehicle;
import com.lori.aspa.exceptions.AppException;
import com.lori.aspa.exceptions.EmptyFieldsException;
import com.lori.aspa.exceptions.TimeOutException;
import com.lori.aspa.model.MyDashboardDTO;
import com.lori.aspa.utils.DateUtil;

@Service
@AppTransactional
public class AuthorizationService {
	
	
	@Autowired
	AuthorizationDAO authorizationDAO;
	@Autowired 
	UserDAO userDAO;
	@Autowired 
	OfficerService officerService;
	@Autowired
	VehicleService vehicleService;
	@Autowired 
	StructureDAO structureDAO;
	@Autowired
	PlaceDAO placeDAO;
	@Autowired
	HistoryDAO historyDAO;
	
	
	
	public AuthorizationDTO findAuthorizationById(Integer authorizationId)
	{
		
		return new Assembler().toDto(authorizationDAO.findById(authorizationId));
	}
	
	public List<AuthorizationDTO> searchAuthorization(AuthorizationReq req)
	{
		AuthorizationSQL criterias = new RequestAssembler().toSql(req);
		return new Assembler().authorizationListToDto(authorizationDAO.search(criterias));
	}
	
	
	public AuthorizationDTO registerAuthorization(AuthorizationDTO dto) throws AppException
	{
		
		if(dto.getUserId() == null) {
			
			throw new EmptyFieldsException("Përdoruesi i papërcaktuar ");
		}
		
		if(dto.getNextUserId() == null) {
			
			throw new EmptyFieldsException("Aprovuesi i autorizimit i papërcaktuar ");
		}
		
        if(dto.getFromDate() == null) {
			
			throw new EmptyFieldsException("Data e nisjes e papërcaktuar ");
		}
		
        if(dto.getToDate() == null) {
			
			throw new EmptyFieldsException("Data e mbërritjes e papërcaktuar ");
		}
        
        if(dto.getFromPlaceId() == null) {
			
			throw new EmptyFieldsException("Vendi i nisjes i papërcaktuar ");
		}
        
        if(dto.getToPlaceId() == null) {
			
			throw new EmptyFieldsException("Vendi i mbërritjes i papërcaktuar ");
		}
        
        if(dto.getOfficers() == null || dto.getOfficers().isEmpty()) {
        	
        	throw new EmptyFieldsException("Punonjësit e papërcaktuar ");
        }
        
        if(dto.getVehicles() == null || dto.getVehicles().isEmpty()) {
        	
        	throw new EmptyFieldsException("Automjetet e papërcaktuar ");
        }
        
        if(dto.getStructureId() == null) {
        	
        	throw new EmptyFieldsException("Struktura e papërcaktuar ");
        }
        
        
        Date from = DateUtil.toDate(dto.getFromDate());
        Date to = DateUtil.toDate(dto.getToDate());
        
        if(!to.after(from))
        {
        	throw new TimeOutException("Data e kthimit duhet pas nisjes");
        }
		
        User user = userDAO.findById(dto.getUserId());
        User nextUser = userDAO.findById(dto.getNextUserId());
        Structure structure = structureDAO.findById(dto.getStructureId());
        Place fromPlace = placeDAO.findById(dto.getFromPlaceId());
        Place toPlace = placeDAO.findById(dto.getToPlaceId());

        List<Vehicle> vehicles = new ArrayList<>();
        for(VehicleDTO d : dto.getVehicles())
        {
        	vehicles.add(new Vehicle(vehicleService.isAvailable(d.getId(), from, to, null).getId()));
        }
        List<Officer> officers = new ArrayList<>();
        for(OfficerDTO o : dto.getOfficers())
        {
        	officers.add(new Officer(officerService.isAvailable(o.getId(), from, to, null).getId()));
        }
        
        
        Authorization auth = new Authorization();
        auth.setCreateTime(Calendar.getInstance().getTime());
        auth.setCreateUser(user);
        auth.setFromDate(from);
        auth.setToDate(to);
        auth.setFromPlace(fromPlace);
        auth.setNextUser(nextUser);
        auth.setOfficers(officers);
        auth.setRank(1);
        auth.setReasonOfTravel(dto.getReasonOfTravel());
        auth.setStatus(IStatus.ACTIVE);
        auth.setToPlace(toPlace);
        auth.setStructure(structure);
        auth.setUser(user);
        auth.setVehicles(vehicles);
        auth.setDecision(IDecision.IN_PROCESS);
        
        auth = authorizationDAO.create(auth);
        
        
        return new Assembler().toDto(auth);
        
        
	}
	
	public AuthorizationDTO modifyAuthorization(AuthorizationDTO dto,String uname) throws AppException
	{
		
		if(dto.getUserId() == null) {
			
			throw new EmptyFieldsException("Përdoruesi i papërcaktuar ");
		}
		
		if(dto.getNextUserId() == null) {
			
			throw new EmptyFieldsException("Aprovuesi i autorizimit i papërcaktuar ");
		}
		
        if(dto.getFromDate() == null) {
			
			throw new EmptyFieldsException("Data e nisjes e papërcaktuar ");
		}
		
        if(dto.getToDate() == null) {
			
			throw new EmptyFieldsException("Data e mbërritjes e papërcaktuar ");
		}
        
        if(dto.getFromPlaceId() == null) {
			
			throw new EmptyFieldsException("Vendi i nisjes i papërcaktuar ");
		}
        
        if(dto.getToPlaceId() == null) {
			
			throw new EmptyFieldsException("Vendi i mbërritjes i papërcaktuar ");
		}
        
        if(dto.getOfficers() == null || dto.getOfficers().isEmpty()) {
        	
        	throw new EmptyFieldsException("Punonjësit e papërcaktuar ");
        }
        
        if(dto.getVehicles() == null || dto.getVehicles().isEmpty()) {
        	
        	throw new EmptyFieldsException("Automjetet e papërcaktuar ");
        }
        
        if(dto.getStructureId() == null) {
        	
        	throw new EmptyFieldsException("Struktura e papërcaktuar ");
        }
        
        
        Date from = DateUtil.toDate(dto.getFromDate());
        Date to = DateUtil.toDate(dto.getToDate());
        
        if(!to.after(from))
        {
        	throw new TimeOutException("Data e kthimit duhet pas nisjes");
        }
		
        User user = userDAO.findByUsername(uname);
        User nextUser = userDAO.findById(dto.getNextUserId());
        Structure structure = structureDAO.findById(dto.getStructureId());
        Place fromPlace = placeDAO.findById(dto.getFromPlaceId());
        Place toPlace = placeDAO.findById(dto.getToPlaceId());

        List<Vehicle> vehicles = new ArrayList<>();
        for(VehicleDTO d : dto.getVehicles())
        {
        	vehicles.add(new Vehicle(vehicleService.isAvailable(d.getId(), from, to, dto.getId()).getId()));
        }
        
        List<Officer> officers = new ArrayList<>();
        for(OfficerDTO o : dto.getOfficers())
        {
        	officers.add(new Officer(officerService.isAvailable(o.getId(), from, to, dto.getId()).getId()));
        }
        
        
        Authorization auth = authorizationDAO.findById(dto.getId());
        auth.setFromDate(from);
        auth.setToDate(to);
        auth.setFromPlace(fromPlace);
        auth.setToPlace(toPlace);
        auth.setNextUser(nextUser);
        auth.setOfficers(officers);
        auth.setVehicles(vehicles);
        auth.setReasonOfTravel(dto.getReasonOfTravel());        
        auth.setStructure(structure);
        
        auth.setUpdateTime(Calendar.getInstance().getTime());
        auth.setUpdateUser(user);
        
        auth = authorizationDAO.update(auth);
        
        
        return new Assembler().toDto(auth);
        
        
	}
	
	public AuthorizationDTO delete(AuthorizationDTO dto)
	{
		Authorization auth = authorizationDAO.findById(dto.getId());
		auth.setCancelDate(Calendar.getInstance().getTime());
		auth.setStatus(IStatus.NOT_ACTIVE);
		return new Assembler().toDto(authorizationDAO.update(auth));
	}
	
	
	public void decide(ApprovalHistoryDTO dto, String uname)
	{
		
		String decision = dto.getDecision();
		if(decision.equals(IDecision.ACCEPT))
		{
			decision = IDecision.IN_PROCESS;
		}
		
		Authorization auth = authorizationDAO.findById(dto.getAuthorizationId());
		auth.setDecision(decision);
		auth = authorizationDAO.update(auth);
		
		User u = userDAO.findByUsername(uname);
		
		ApprovalHistory ah = new ApprovalHistory();
		ah.setAuthorozation(auth);
		ah.setDecision(dto.getDecision());
		ah.setCreateTime(Calendar.getInstance().getTime());
		ah.setCreateUser(u);
		ah.setDecisionTime(Calendar.getInstance().getTime());
		ah.setReason(dto.getReason());
		ah.setStatus(IStatus.ACTIVE);
		ah.setUser(u);
		
		ah = historyDAO.create(ah);
		
	}
	
	public MyDashboardDTO getMydashboard(String uname)
	{
		User u = userDAO.findByUsername(uname);
		
		MyDashboardDTO dto = new MyDashboardDTO();
		dto.setApproved(authorizationDAO.count(IDecision.ACCEPT,u));
		dto.setDenied(authorizationDAO.count(IDecision.DENY,u));
		dto.setReturned(authorizationDAO.count(IDecision.RETURNED,u));
		dto.setInProcess(authorizationDAO.count(IDecision.IN_PROCESS,u));
		
		return dto;
		
	}
	
	

}
