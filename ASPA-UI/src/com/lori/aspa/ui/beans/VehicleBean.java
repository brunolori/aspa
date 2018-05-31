package com.lori.aspa.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.lori.aspa.ui.clients.ApiException;
import com.lori.aspa.ui.models.StructureDTO;
import com.lori.aspa.ui.models.VehicleDTO;
import com.lori.aspa.ui.models.VehicleTypeDTO;
import com.lori.aspa.ui.services.StructureService;
import com.lori.aspa.ui.services.VehicleService;
import com.lori.aspa.ui.utils.Messages;

@ManagedBean
@ViewScoped
public class VehicleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{loginBean}")
	LoginBean login;

	String token;
	Integer userId;

	List<VehicleDTO> vehicles;
	List<VehicleTypeDTO> vehicleTypes;
	List<StructureDTO> structures;

	VehicleDTO vehicle;
	VehicleDTO selectedVehicle;

	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	public List<VehicleDTO> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<VehicleDTO> vehicles) {
		this.vehicles = vehicles;
	}

	public VehicleDTO getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleDTO vehicle) {
		this.vehicle = vehicle;
	}

	public VehicleDTO getSelectedVehicle() {
		return selectedVehicle;
	}

	public void setSelectedVehicle(VehicleDTO selectedVehicle) {
		this.selectedVehicle = selectedVehicle;
	}

	public List<VehicleTypeDTO> getVehicleTypes() {
		return vehicleTypes;
	}

	public void setVehicleTypes(List<VehicleTypeDTO> vehicleTypes) {
		this.vehicleTypes = vehicleTypes;
	}

	public List<StructureDTO> getStructures() {
		return structures;
	}

	public void setStructures(List<StructureDTO> structures) {
		this.structures = structures;
	}

	@PostConstruct
	public void load() {
		this.userId = login.getUserToken().getUser().getId();
		this.token = login.getUserToken().getToken();

		init();
	}

	private void init() {
		this.vehicle = new VehicleDTO();
		this.selectedVehicle = null;
		this.structures = new StructureService().getUserStructures(token);
		this.vehicleTypes = new VehicleService().loadVehicleTypes();
		this.vehicles = new VehicleService().getUserVehicles(token);

	}

	public void clear() {
		init();
	}

	public void onVehicleSelected() {
		this.vehicle = selectedVehicle;
	}

	public void register() {

		try {
			new VehicleService().registerVehicle(vehicle, token);
			Messages.throwFacesMessage("Automjeti u regjistrua me sukses", 1);
			init();
		} catch (ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}

	public void modify() {
		try {
			new VehicleService().modifyVehicle(vehicle, token);
			Messages.throwFacesMessage("Automjeti u modifikua me sukses", 1);
			init();
		} catch (ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}

	public void delete() {
		try {
		new VehicleService().deleteVehicle(vehicle, token);
		Messages.throwFacesMessage("Automjeti u fshi me sukses", 1);
		}catch(ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
		
	}

}
