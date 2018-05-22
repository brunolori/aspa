package com.lori.aspa.ui.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.lori.aspa.ui.clients.ApiException;
import com.lori.aspa.ui.models.AuthorizationDTO;
import com.lori.aspa.ui.models.OfficerDTO;
import com.lori.aspa.ui.models.PlaceDTO;
import com.lori.aspa.ui.models.StructureDTO;
import com.lori.aspa.ui.models.UserDTO;
import com.lori.aspa.ui.models.VehicleDTO;
import com.lori.aspa.ui.services.AuthService;
import com.lori.aspa.ui.services.OfficerService;
import com.lori.aspa.ui.services.PlaceService;
import com.lori.aspa.ui.services.StructureService;
import com.lori.aspa.ui.services.UserService;
import com.lori.aspa.ui.services.VehicleService;
import com.lori.aspa.ui.utils.Messages;

@ManagedBean
@ViewScoped
public class NewAuthBean implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@ManagedProperty(value="#{loginBean}")
	LoginBean login;
	
	String token;
	Integer userId;
	
	
	List<StructureDTO> structures;
	List<PlaceDTO> places;
	List<VehicleDTO> vehicles;
	
	List<OfficerDTO> selectedOfficers;
	List<VehicleDTO> selectedVehicles;
	
	OfficerDTO selectedOfficer;
	UserDTO nextUser;
	
	AuthorizationDTO auth;
	
	
	
	public List<StructureDTO> getStructures() {
		return structures;
	}
	public void setStructures(List<StructureDTO> structures) {
		this.structures = structures;
	}
	public List<PlaceDTO> getPlaces() {
		return places;
	}
	public void setPlaces(List<PlaceDTO> places) {
		this.places = places;
	}
	public List<VehicleDTO> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<VehicleDTO> vehicles) {
		this.vehicles = vehicles;
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
	public OfficerDTO getSelectedOfficer() {
		return selectedOfficer;
	}
	public void setSelectedOfficer(OfficerDTO selectedOfficer) {
		this.selectedOfficer = selectedOfficer;
	}
	public AuthorizationDTO getAuth() {
		return auth;
	}
	public void setAuth(AuthorizationDTO auth) {
		this.auth = auth;
	}	
	public LoginBean getLogin() {
		return login;
	}
	public void setLogin(LoginBean login) {
		this.login = login;
	}

	public UserDTO getNextUser() {
		return nextUser;
	}
	public void setNextUser(UserDTO nextUser) {
		this.nextUser = nextUser;
	}
	
	
	
	@PostConstruct
	public void load()
	{
		this.userId = login.getUserToken().getUser().getId();
		this.token = login.getUserToken().getToken();
		
		this.structures = new StructureService().getUserStructures(token);
		this.vehicles = new VehicleService().getUserVehicles(token);
		this.places = new PlaceService().loadPlaces();
		
		init();
	}
	
	private void init()
	{
		this.auth = new AuthorizationDTO();
		this.selectedOfficers = new ArrayList<>();
		this.selectedVehicles = new ArrayList<>();
		this.selectedOfficer = null;
		this.nextUser = null;

	}
	
	public void clear()
	{
		init();
	}
	
	public void register()
	{
		
		if(selectedOfficers.isEmpty())
		{
			Messages.throwFacesMessage("Zgjidhni punonjesit", 2);
			return;
		}
		if(selectedVehicles.isEmpty())
		{
			Messages.throwFacesMessage("Zgjidhni automjetin", 2);
			return;
		}
		if(nextUser == null)
		{
			Messages.throwFacesMessage("Zgjidhni ku do e delegoni", 2);
			return;
		}
		
		try {
			auth.setNextUserId(nextUser.getId());
			new AuthService().registerAuthorization(auth, selectedOfficers, selectedVehicles, token);
			Messages.throwFacesMessage("Autorizimi u regjistrua me sukses", 1);
		    init();
		}catch(ApiException a)
		{
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}
	
	
	public List<OfficerDTO> searchOfficer(String query)
	{
		return new OfficerService().queryOfficer(query);
	}
	
	public List<UserDTO> searchUser(String query)
	{
		return new UserService().queryUser(query);
	}
	
	public void onOfficerSelect()
	{
		if(!selectedOfficers.isEmpty())
		{
			for(OfficerDTO o : selectedOfficers)
			{
				if(o.getId() == selectedOfficer.getId())
				{
					Messages.throwFacesMessage("Punonjesin "+selectedOfficer.fullName()+" e keni zgjedhur njehere", 3);
					this.selectedOfficer = null;
					return;
				}
			}
		}
		
		this.selectedOfficers.add(selectedOfficer);
		this.selectedOfficer = null;
	}
	
	public void removeOfficer(OfficerDTO o)
	{
		this.selectedOfficers.remove(o);
	}
	
	
	
	
}
