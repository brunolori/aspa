package com.lori.aspa.ui.services;

import java.util.List;

import com.lori.aspa.ui.clients.VehicleClient;
import com.lori.aspa.ui.criterias.VehicleReq;
import com.lori.aspa.ui.models.VehicleDTO;

public class VehicleService {

	
	
	public VehicleDTO findVehicleById(Integer id)
	{
		return new VehicleClient().findVehicleById(id);
	}
	
	public List<VehicleDTO> getUserVehicles(String token)
	{
		return new VehicleClient().getUserVehicles(token);
	}
	
	public VehicleDTO registerVehicle(VehicleDTO vehicle, String token)
	{
		
		return new VehicleClient().registerVehicle(vehicle, token);
	}
	
	public VehicleDTO modifyVehicle(VehicleDTO vehicle, String token)
	{
		return new VehicleClient().modifyVehicle(vehicle, token);
	}
	
	public VehicleDTO deleteVehicle(VehicleDTO vehicle, String token)
	{
		return new VehicleClient().deleteVehicle(vehicle, token);
	}
	
	public List<VehicleDTO> searchVehicles(VehicleReq req,String token)
	{
		return new VehicleClient().searchVehicles(req, token);
	}
	
	
}
