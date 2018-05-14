package com.lori.aspa.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lori.aspa.ui.models.AuthorizationDTO;
import com.lori.aspa.ui.models.MyDashboardDTO;

@ManagedBean
@ViewScoped
public class DashboardBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	MyDashboardDTO dashboard;
	List<AuthorizationDTO> auths;
	
	
	
	
	
	
	
	public MyDashboardDTO getDashboard() {
		return dashboard;
	}

	public void setDashboard(MyDashboardDTO dashboard) {
		this.dashboard = dashboard;
	}

	public List<AuthorizationDTO> getAuths() {
		return auths;
	}

	public void setAuths(List<AuthorizationDTO> auths) {
		this.auths = auths;
	}

	
	@PostConstruct
	public void load()
	{
		loadDashboard();
		loadAuths(null);
	}
	
	public void loadDashboard()
	{}
	
	public void loadAuths(String type)
	{
		
	}
	

}
