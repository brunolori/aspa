package com.lori.aspa.assemblers;

import java.util.ArrayList;
import java.util.List;

import com.lori.aspa.constants.IStatus;
import com.lori.aspa.dto.ApprovalHistoryDTO;
import com.lori.aspa.dto.AuthorizationDTO;
import com.lori.aspa.dto.CityDTO;
import com.lori.aspa.dto.MunicipalityDTO;
import com.lori.aspa.dto.OfficerDTO;
import com.lori.aspa.dto.PlaceDTO;
import com.lori.aspa.dto.RankPathDTO;
import com.lori.aspa.dto.RegionDTO;
import com.lori.aspa.dto.RoleDTO;
import com.lori.aspa.dto.StructureDTO;
import com.lori.aspa.dto.TravelDTO;
import com.lori.aspa.dto.UserDTO;
import com.lori.aspa.dto.VehicleDTO;
import com.lori.aspa.dto.VehicleTypeDTO;
import com.lori.aspa.entities.ApprovalHistory;
import com.lori.aspa.entities.Authorization;
import com.lori.aspa.entities.City;
import com.lori.aspa.entities.Municipality;
import com.lori.aspa.entities.Officer;
import com.lori.aspa.entities.Place;
import com.lori.aspa.entities.RankPath;
import com.lori.aspa.entities.Region;
import com.lori.aspa.entities.Role;
import com.lori.aspa.entities.Structure;
import com.lori.aspa.entities.Travel;
import com.lori.aspa.entities.User;
import com.lori.aspa.entities.Vehicle;
import com.lori.aspa.entities.VehicleType;
import com.lori.aspa.utils.DateUtil;

public class Assembler {
	
	
	
	
	public ApprovalHistoryDTO toDto(ApprovalHistory e)
	{
		
		if(e == null) return null;
		
		ApprovalHistoryDTO dto = new ApprovalHistoryDTO();
		
		dto.setId(e.getId());
		dto.setReason(e.getReason());
		dto.setActive(e.getStatus() == IStatus.ACTIVE);
		dto.setDecisionTime(DateUtil.formatTimestamp(e.getDecisionTime()));
		dto.setAuthorizationId(e.getAuthorization().getId());
		dto.setDecision(e.getDecision());
		//dto.setRank(e.getRankPath().getRank());
		dto.setStructure(e.getAuthorization().getStructure().getName());
		dto.setStructureId(e.getAuthorization().getStructure().getId());
		dto.setUser(e.getUser().getUsername());
		dto.setUserId(e.getUser().getId());
		if(e.getNextUser() != null)
		{
		   dto.setNextUserId(e.getNextUser().getId());
		}
		return dto;
		
	}
	
	
	
	public List<ApprovalHistoryDTO> approvalHistoryListToDto(List<ApprovalHistory> approvalHistories)
	{

		if (approvalHistories == null || approvalHistories.isEmpty()) return null;

		List<ApprovalHistoryDTO> list = new ArrayList<>();

		for (ApprovalHistory ah : approvalHistories)
		{

			list.add(toDto(ah));
		}

		return list;
	}
	
	public AuthorizationDTO toDto(Authorization e)
	{
		
		if(e == null) return null;
		
		AuthorizationDTO dto = new AuthorizationDTO();
		
		dto.setId(e.getId());
		dto.setDecision(e.getDecision());
		dto.setAuthorizationDate(DateUtil.formatTimestamp(e.getCreateTime()));
		dto.setCancelDate(DateUtil.formatTimestamp(e.getCancelDate()));
		dto.setFinalApprovedDate(DateUtil.formatTimestamp(e.getFinalApprovedDate()));
		dto.setActive(e.getStatus() == IStatus.ACTIVE);
		dto.setFromDate(DateUtil.formatDate(e.getFromDate()));
		dto.setFromPlace(e.getFromPlace().getName());
		dto.setFromPlaceId(e.getFromPlace().getId());
		dto.setRank(e.getRank());
		dto.setServiceObjectives(e.getServiceObjectives());
		dto.setServiceRaporting(e.getServiceRaporting());
		dto.setReasonOfTravel(e.getReasonOfTravel());
		dto.setStructure(e.getStructure().getName());
		dto.setStructureId(e.getStructure().getId());
		dto.setToDate(DateUtil.formatDate(e.getToDate()));
		dto.setToPlace(e.getToPlace().getName());
		dto.setToPlaceId(e.getToPlace().getId());
		dto.setUser(e.getUser().getUsername());
		dto.setUserId(e.getUser().getId());
		dto.setNextUserId(e.getNextUser().getId());
		dto.setNextUser(e.getNextUser().getOfficer().getName()+" "+e.getNextUser().getOfficer().getSurname());
		dto.setNextStructure(e.getNextUser().getOfficer().getStructure().getName());
		if(e.getOfficers() != null && !e.getOfficers().isEmpty())
		{
				dto.setOfficers(officerListToDto(e.getOfficers()));
		}
		if(e.getVehicles() != null && !e.getVehicles().isEmpty())
		{
				dto.setVehicles(vehicleListToDto(e.getVehicles()));
		}
		
		return dto;
		
	}
	
	
	
	public List<AuthorizationDTO> authorizationListToDto(List<Authorization> e)
	{

		if (e == null || e.isEmpty()) return null;

		List<AuthorizationDTO> list = new ArrayList<>();

		for (Authorization i : e)
		{

			list.add(toDto(i));
		}

		return list;
	}
	
	public MunicipalityDTO toDto(Municipality m) 
	{

		if (m == null) return null;

		MunicipalityDTO dto = new MunicipalityDTO();

		dto.setId(m.getId());
		dto.setName(m.getName());
		dto.setCity(m.getCity().getName());
		dto.setCityId(m.getCity().getId());
	

		return dto;

	}

	public List<MunicipalityDTO> municipalityListToDto(List<Municipality> e)
	{

		if (e == null || e.isEmpty()) return null;

		List<MunicipalityDTO> list = new ArrayList<>();

		for (Municipality i : e)
		{

			list.add(toDto(i));
		}

		return list;
	}
	

	public CityDTO toDto(City city) 
	{

		if (city == null) return null;

		CityDTO dto = new CityDTO();

		dto.setId(city.getId());
		dto.setName(city.getName());
		dto.setRegion(city.getRegion().getName());
		dto.setRegionId(city.getRegion().getId());
	

		return dto;

	}

	public List<CityDTO> cityListToDto(List<City> cities)
	{

		if (cities == null || cities.isEmpty()) return null;

		List<CityDTO> list = new ArrayList<>();

		for (City c : cities)
		{

			list.add(toDto(c));
		}

		return list;
	}

	public VehicleTypeDTO toDto(VehicleType vehicleType) 
	{

		if (vehicleType == null) return null;

		VehicleTypeDTO dto = new VehicleTypeDTO();

		dto.setId(vehicleType.getId());
		dto.setTag(vehicleType.getTag());
		dto.setActive(vehicleType.getStatus() == IStatus.ACTIVE);
		dto.setDescription(vehicleType.getDescription());

		return dto;
	}

	public List<VehicleTypeDTO> vehicleTypeListToDto(List<VehicleType> vehicleTypes)
	{

		if (vehicleTypes == null || vehicleTypes.isEmpty())	return null;

		List<VehicleTypeDTO> list = new ArrayList<>();

		for (VehicleType vt : vehicleTypes) 
		{
			list.add(toDto(vt));
		}

		return list;

	}

	public RegionDTO todto(Region region)
	{

		if (region == null) return null;

		RegionDTO dto = new RegionDTO();

		dto.setId(region.getId());
		dto.setName(region.getName());

		return dto;

	}

	public List<RegionDTO> regionListToDto(List<Region> regions) 
	{

		if (regions == null || regions.isEmpty()) return null;

		List<RegionDTO> list = new ArrayList<>();

		for (Region r : regions) 
		{

			list.add(todto(r));
		}

		return list;

	}
	
	public RoleDTO toDto(Role role)
	{
		
		if(role == null) return null;
		
		RoleDTO dto = new RoleDTO();
		
		dto.setId(role.getId());
		dto.setActive(role.getStatus() == IStatus.ACTIVE);
		dto.setTag(role.getTag());
		dto.setDescription(role.getDescription());
		
		return dto;
		
	}
	
	public List<RoleDTO> roleListToDto(List<Role> roles)
	{
		
		if(roles == null || roles.isEmpty()) return null;
		
		List<RoleDTO> list = new ArrayList<>();
		
		for(Role r : roles)
		{
			list.add(toDto(r));
		}
		
		return list;
	}
	
	
	public OfficerDTO toDto(Officer e)
	{
		
		if(e == null) return null;
		
		OfficerDTO dto = new OfficerDTO();
		
		dto.setActive(e.getStatus() == IStatus.ACTIVE);
		dto.setFunction(e.getFunction());
		dto.setGrade(e.getGrade());
		dto.setId(e.getId());
		dto.setName(e.getName());
		dto.setPosition(e.getPosition());
		if(e.getStructure() != null) {
			dto.setStructure(e.getStructure().getName());
			dto.setStructureId(e.getStructure().getId());
		}
		dto.setSurname(e.getSurname());
		
		return dto;
		
	}
	
	
	public List<OfficerDTO> officerListToDto(List<Officer> e)
	{

		if (e == null || e.isEmpty()) return null;

		List<OfficerDTO> list = new ArrayList<>();

		for (Officer i : e)
		{

			list.add(toDto(i));
		}

		return list;
	}
	
	
	public PlaceDTO toDto(Place e)
	{
		
		if(e == null) return null;
		
		PlaceDTO dto = new PlaceDTO();
		
		dto.setActive(e.getStatus() == IStatus.ACTIVE);
		dto.setId(e.getId());
		dto.setName(e.getName());
		dto.setMunicipality(e.getMunicipality().getName());
		dto.setMunicipalityId(e.getMunicipality().getId());

		
		return dto;
		
	}
	
	
	public List<PlaceDTO> placeListToDto(List<Place> e)
	{

		if (e == null || e.isEmpty()) return null;

		List<PlaceDTO> list = new ArrayList<>();

		for (Place i : e)
		{

			list.add(toDto(i));
		}

		return list;
	}
	
	
	public RankPathDTO toDto(RankPath e)
	{
		
		if(e == null) return null;
		
		RankPathDTO dto = new RankPathDTO();
		
		dto.setActive(e.getStatus() == IStatus.ACTIVE);
		dto.setId(e.getId());
		dto.setOfficer(e.getOfficer().getName()+" "+e.getOfficer().getSurname());
		dto.setOfficerGrade(e.getOfficer().getGrade());
		dto.setOfficerId(e.getOfficer().getId());
		dto.setOfficerPosition(e.getOfficer().getPosition());
		dto.setOfficerStructure(e.getOfficer().getStructure().getName());
		dto.setOfficerStructureId(e.getOfficer().getStructure().getId());
		dto.setRank(e.getRank());
		dto.setStructure(e.getStructure().getName());
		dto.setStructureId(e.getStructure().getId());
		
		
		return dto;
		
	}
	
	
	public List<RankPathDTO> rankPathListToDto(List<RankPath> e)
	{

		if (e == null || e.isEmpty()) return null;

		List<RankPathDTO> list = new ArrayList<>();

		for (RankPath i : e)
		{

			list.add(toDto(i));
		}

		return list;
	}
	
	
	public StructureDTO toDto(Structure e) 
	{

		if (e == null)
			return null;

		StructureDTO dto = new StructureDTO();

		dto.setActive(e.getStatus() == IStatus.ACTIVE);
		dto.setId(e.getId());
		dto.setName(e.getName());
		dto.setCode(e.getCode());
		if(e.getParent() != null) {
	    dto.setParent(e.getParent().getName());
		dto.setParentId(e.getParent().getId());
		}
		return dto;

	}

	public List<StructureDTO> structureListToDto(List<Structure> e) 
	{

		if (e == null || e.isEmpty())
			return null;

		List<StructureDTO> list = new ArrayList<>();

		for (Structure i : e) 
		{

			list.add(toDto(i));
		}

		return list;
	}
	
	
	public TravelDTO toDto(Travel e) 
	{

		if (e == null)
			return null;

		TravelDTO dto = new TravelDTO();

		dto.setActive(e.getStatus() == IStatus.ACTIVE);
		dto.setId(e.getId());
		dto.setFromPlace(e.getFromPlace().getName());
		dto.setFromPlaceId(e.getFromPlace().getId());
		dto.setToPlace(e.getToPlace().getName());
		dto.setToPlaceId(e.getToPlace().getId());
		dto.setStartDate(DateUtil.formatDate(e.getStartDate()));
		dto.setEndDate(DateUtil.formatDate(e.getEndDate()));
		dto.setStartTime(DateUtil.formatHourM(e.getStartTime()));
		dto.setEndTime(DateUtil.formatHourM(e.getEndTime()));
		dto.setAuthorizationId(e.getAuthorization().getId());

		return dto;

	}

	public List<TravelDTO> travelListToDto(List<Travel> e) 
	{

		if (e == null || e.isEmpty())
			return null;

		List<TravelDTO> list = new ArrayList<>();

		for (Travel i : e) 
		{

			list.add(toDto(i));
		}

		return list;
	}
	
	
	public UserDTO toDto(User e) 
	{

		if (e == null)
			return null;

		UserDTO dto = new UserDTO();

		dto.setActive(e.getStatus() == IStatus.ACTIVE);
		dto.setId(e.getId());
		dto.setUsername(e.getUsername());
		dto.setSecret(e.getSecret());
		dto.setRegisterDate(DateUtil.formatTimestamp(e.getCreateTime()));
		dto.setRegisterUser(e.getCreateUser().getUsername());
		dto.setRegisterUserId(e.getCreateUser().getId());
		dto.setLastUpdate(DateUtil.formatTimestamp(e.getUpdateTime()));
		dto.setFinalApproval(e.getFinalApproval() != null && e.getFinalApproval() == IStatus.ACTIVE);
		
		if(e.getUpdateUser() != null) {
		  dto.setUpdateUser(e.getUpdateUser().getUsername());
		  dto.setUpdateUserId(e.getUpdateUser().getId());
		}
		
		dto.setOfficer(toDto(e.getOfficer()));
		dto.setRoles(roleListToDto(e.getRoles()));
		
			

		return dto;

	}

	public List<UserDTO> userListToDto(List<User> e) 
	{

		if (e == null || e.isEmpty())
			return null;

		List<UserDTO> list = new ArrayList<>();

		for (User i : e) 
		{

			list.add(toDto(i));
		}

		return list;
	}


	public VehicleDTO toDto(Vehicle e) 
	{

		if (e == null)
			return null;

		VehicleDTO dto = new VehicleDTO();

		dto.setActive(e.getStatus() == IStatus.ACTIVE);
		dto.setId(e.getId());
		dto.setPlate(e.getPlate());
		dto.setCapacity(e.getCapacity());
		dto.setCarriage(e.getCarriage() == IStatus.ACTIVE);
		dto.setDescription(e.getDescription());
		if(e.getStructure() != null) {
			dto.setStructure(e.getStructure().getName());
			dto.setStructureId(e.getStructure().getId());
		}
		if(e.getType() != null) {
			dto.setType(e.getType().getDescription());
			dto.setTypeCode(e.getType().getTag());
		}
	
		return dto;

	}

	public List<VehicleDTO> vehicleListToDto(List<Vehicle> e) 
	{

		if (e == null || e.isEmpty())
			return null;

		List<VehicleDTO> list = new ArrayList<>();

		for (Vehicle i : e) 
		{

			list.add(toDto(i));
		}

		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
