package com.lori.aspa.ui.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.lori.aspa.ui.models.AuthorizationDTO;
import com.lori.aspa.ui.models.OfficerDTO;
import com.lori.aspa.ui.models.PlaceDTO;
import com.lori.aspa.ui.models.StructureDTO;
import com.lori.aspa.ui.models.UserDTO;
import com.lori.aspa.ui.models.VehicleDTO;

@ManagedBean
@ViewScoped
public class NewAuthBean implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@ManagedProperty(value="#{loginBean}")
	LoginBean login;
	
	List<StructureDTO> structures;
	List<PlaceDTO> places;
	List<VehicleDTO> vehicles;
	
	List<OfficerDTO> selectedOfficers;
	List<VehicleDTO> selectedVehicles;
	
	OfficerDTO selectedOfficer;
	UserDTO selectedNextUser;
	
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
	public UserDTO getSelectedNextUser() {
		return selectedNextUser;
	}
	public void setSelectedNextUser(UserDTO selectedNextUser) {
		this.selectedNextUser = selectedNextUser;
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
	
	
	@PostConstruct
	public void load()
	{
		this.structures = null;// mbushi
		this.vehicles = null;
		this.places = null;
		
		init();
	}
	
	private void init()
	{
		this.auth = new AuthorizationDTO();

	}
	
	public void clear()
	{
		init();
	}
	
	public void register()
	{
		init();
	}
	
	
	public List<OfficerDTO> searchOfficer(String query)
	{
		return new ArrayList<>();
	}
	
	public List<UserDTO> searchUser(String query)
	{
		return new ArrayList<>();
	}
	
	public void onOfficerSelect()
	{
		
	}
	
	public void removeOfficer(OfficerDTO o)
	{
		
	}
	
	
	
	
}
