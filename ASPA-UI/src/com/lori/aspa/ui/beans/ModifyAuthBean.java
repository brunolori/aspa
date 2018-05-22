package com.lori.aspa.ui.beans;

import java.io.Serializable;
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
import com.lori.aspa.ui.utils.Util;

@ManagedBean
@ViewScoped
public class ModifyAuthBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{loginBean}")
	LoginBean login;
	
	String token;
	Integer userId;
	
	
	
	AuthorizationDTO auth;
	
	List<VehicleDTO> vehicles;
	List<PlaceDTO> places;
    List<StructureDTO> structures;
    List<UserDTO> users;
	
	List<OfficerDTO> selectedOfficers;
	List<VehicleDTO> selectedVehicles;

	OfficerDTO selectedOfficer;

	

	
	public AuthorizationDTO getAuth() {
		return auth;
	}
    public void setAuth(AuthorizationDTO auth) {
		this.auth = auth;
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
	public LoginBean getLogin() {
		return login;
	}
	public void setLogin(LoginBean login) {
		this.login = login;
	}
	public List<UserDTO> getUsers() {
		return users;
	}
	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
	
	
	
	@PostConstruct
	public void load() {
		
		this.userId = login.getUserToken().getUser().getId();
		this.token = login.getUserToken().getToken();
		
		String idString = Util.getParam("auth_id");
		
		try {
			
			Integer id = Integer.valueOf(idString);
			this.auth = new AuthService().getAuthorizationById(id);
			if(auth==null)
			{
				Util.redirect("sec/my_auth_dashboard");
			}
			else 
			{
				this.structures = new StructureService().getUserStructures(token);
				this.vehicles = new VehicleService().getUserVehicles(token);
				this.places = new PlaceService().loadPlaces();
				this.users = new UserService().queryUser("");
				
				this.selectedVehicles = auth.getVehicles();
				this.selectedOfficers = auth.getOfficers();
			}
		   
		}catch(NumberFormatException ne) {
			Util.redirect("sec/my_auth_dashboard");
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
	
	
	public void modify() {
		try {
			this.auth = new AuthService().modifyAuthorization(auth, selectedOfficers, selectedVehicles, token);
			Messages.throwFacesMessage("Autorizimi u ndryshua me sukses", 1);
		}catch(ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
				
	}
	
	public void viewAuth()
	{
		Util.redirect("sec/my_auth_view?auth_id="+auth.getId());
	}

}
