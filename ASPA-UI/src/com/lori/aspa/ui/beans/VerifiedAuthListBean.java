package com.lori.aspa.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.lori.aspa.ui.models.AuthorizationDTO;
import com.lori.aspa.ui.services.AuthService;
import com.lori.aspa.ui.utils.Util;

@ManagedBean
@RequestScoped
public class VerifiedAuthListBean implements Serializable {
	

	private static final long serialVersionUID = 1L;
	

	@ManagedProperty(value="#{loginBean}")
	LoginBean login;
	
	String token;
	Integer userId;
	
	
	List<AuthorizationDTO> auths;
	AuthorizationDTO selectedAuth;
	
	
	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	public List<AuthorizationDTO> getAuths() {
		return auths;
	}

	public void setAuths(List<AuthorizationDTO> auths) {
		this.auths = auths;
	}

	public AuthorizationDTO getSelectedAuth() {
		return selectedAuth;
	}

	public void setSelectedAuth(AuthorizationDTO selectedAuth) {
		this.selectedAuth = selectedAuth;
	}

	
	
	
	@PostConstruct
	public void load()
	{
		this.userId = login.getUserToken().getUser().getId();
		this.token = login.getUserToken().getToken();
		
		this.auths = new AuthService().getVerifiedAuths(token);
		this.selectedAuth = null;
	}
	
	public void onAuthSelect()
	{
		Util.redirect("sec/verified_auth_view?auth_id="+selectedAuth.getId());
	}
	
	
}
	