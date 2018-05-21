package com.lori.aspa.ui.services;

import java.util.List;

import com.lori.aspa.ui.clients.AuthClient;
import com.lori.aspa.ui.criterias.AuthorizationReq;
import com.lori.aspa.ui.models.ApprovalHistoryDTO;
import com.lori.aspa.ui.models.AuthorizationDTO;
import com.lori.aspa.ui.models.MyDashboardDTO;
import com.lori.aspa.ui.models.OfficerDTO;
import com.lori.aspa.ui.models.VehicleDTO;

public class AuthService {

	
	public AuthorizationDTO getAuthorizationById(Integer authId)
	{
		return new AuthClient().getAuthorizationById(authId);
	}
	
	public AuthorizationDTO registerAuthorization(AuthorizationDTO auth, List<OfficerDTO> officers, List<VehicleDTO> vehicles, String token)
	{
		auth.setVehicles(vehicles);
		auth.setOfficers(officers);
		
		return new AuthClient().registerAuthorization(auth, token);
	}
	
	public AuthorizationDTO modifyAuthorization(AuthorizationDTO auth, List<OfficerDTO> officers, List<VehicleDTO> vehicles, String token)
	{
		auth.setVehicles(vehicles);
		auth.setOfficers(officers);
		return new AuthClient().modifyAuthorization(auth, token);
	}
	
	public AuthorizationDTO deleteAuthorization(AuthorizationDTO auth, String token)
	{
		return new AuthClient().deleteAuthorization(auth, token);
	}
	
	public List<AuthorizationDTO> searchAuthorization(AuthorizationReq req,String token)
	{
		return new AuthClient().searchAuthorization(req, token);
	}
	
	public MyDashboardDTO getMyDashboard(String token)
	{
		return new AuthClient().getMyDashboard(token);
	}
	
	public void decide(ApprovalHistoryDTO history, String token)
	{
		new AuthClient().decide(history, token);
	}
	
	public List<AuthorizationDTO> getAuthsToVerify(String token)
	{
		return new AuthClient().getAuthsToVerify(token);
	}
	
	public List<AuthorizationDTO> getVerifiedAuths(String token)
	{
		return new AuthClient().getVerifiedAuths(token);
	}
	
	public List<ApprovalHistoryDTO> getAuthHistory(AuthorizationDTO auth, String token)
	{
		 return new AuthClient().getAuthHistory(auth, token);
	}
	
	
	
	
	
	
}
