package com.lori.aspa.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.lori.aspa.ui.criterias.AuthorizationReq;
import com.lori.aspa.ui.models.AuthorizationDTO;
import com.lori.aspa.ui.models.MyDashboardDTO;
import com.lori.aspa.ui.services.AuthService;

@ManagedBean
@ViewScoped
public class DashboardBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{loginBean}")
	LoginBean login;
	
	String token;
	Integer userId;
	
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
	
	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	
	
	@PostConstruct
	public void load()
	{
		this.userId = login.getUserToken().getUser().getId();
		this.token = login.getUserToken().getToken();
		loadDashboard();
		loadAuths(null);
	}
	
	public void loadDashboard()
	{
		this.dashboard = new AuthService().getMyDashboard(token);
	}
	
	public void loadAuths(String type)
	{
		AuthorizationReq req = new AuthorizationReq();		
		req.setUserId(userId);
		req.setDecision(type);	
		this.auths = new AuthService().searchAuthorization(req, token);
	}
	

}
