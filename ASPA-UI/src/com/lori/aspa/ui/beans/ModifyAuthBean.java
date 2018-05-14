package com.lori.aspa.ui.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lori.aspa.ui.models.AuthorizationDTO;
import com.lori.aspa.ui.models.OfficerDTO;
import com.lori.aspa.ui.models.PlaceDTO;
import com.lori.aspa.ui.models.StructureDTO;
import com.lori.aspa.ui.models.UserDTO;
import com.lori.aspa.ui.models.VehicleDTO;
import com.lori.aspa.ui.services.AuthService;
import com.lori.aspa.ui.utils.Util;

@ManagedBean
@ViewScoped
public class ModifyAuthBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	AuthorizationDTO auth;
	List<OfficerDTO> officers;
	List<VehicleDTO> vehicles;
	List<PlaceDTO> places;
    List<StructureDTO> structures;
	
	List<OfficerDTO> selectedOfficers;
	List<VehicleDTO> selectedVehicles;

	OfficerDTO selectedOfficer;

	

	
	public AuthorizationDTO getAuth() {
		return auth;
	}
    public void setAuth(AuthorizationDTO auth) {
		this.auth = auth;
	}
	public List<OfficerDTO> getOfficers() {
		return officers;
	}
	public void setOfficers(List<OfficerDTO> officers) {
		this.officers = officers;
	}
	public List<VehicleDTO> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<VehicleDTO> vehicles) {
		this.vehicles = vehicles;
	}
	public List<PlaceDTO> getPlaces() {
		return places;
	}
	public void setPlaces(List<PlaceDTO> places) {
		this.places = places;
	}
	public List<OfficerDTO> getSelectedOfficers() {
		return selectedOfficers;
	}
	public void setSelectedOfficers(List<OfficerDTO> selectedOfficers) {
		this.selectedOfficers = selectedOfficers;
	}
	public List<VehicleDTO> getSelectedVehicles() {
		return selectedVehicles;
	}
	public void setSelectedVehicles(List<VehicleDTO> selectedVehicles) {
		this.selectedVehicles = selectedVehicles;
	}
	public List<StructureDTO> getStructures() {
		return structures;
	}
	public void setStructures(List<StructureDTO> structures) {
		this.structures = structures;
	}
	public OfficerDTO getSelectedOfficer() {
		return selectedOfficer;
	}
	public void setSelectedOfficer(OfficerDTO selectedOfficer) {
		this.selectedOfficer = selectedOfficer;
	}

	
	
	

	@PostConstruct
	public void load() {
		
		String idStr = Util.getParam("auth_id");
		try {
			
		   Integer id = Integer.valueOf(idStr);
		   this.auth = new AuthService().getAuthorizationById(id, null);
		   this.structures = null;// mbushi
		   this.vehicles = null;
		   this.places = null;
		   this.selectedVehicles = auth.getVehicles();
		   this.selectedOfficers = auth.getOfficers();
		   
		   
		}catch(NumberFormatException ne) {
			Util.redirect("sec/my_auth_dashboard");
		}
		
		
	}
	
	
	public List<UserDTO> searchUser(String query) {
		return new ArrayList<>();
	}

	public List<OfficerDTO> searchOfficer(String query) {
		return new ArrayList<>();
	}

	public void onOfficerSelect() {
	}

	public void removeOfficer(OfficerDTO o) {

	}
	
	public void modify() {}
	

}
