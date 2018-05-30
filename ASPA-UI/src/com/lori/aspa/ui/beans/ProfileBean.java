package com.lori.aspa.ui.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.lori.aspa.ui.models.UserDTO;

@ManagedBean
@RequestScoped
public class ProfileBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{loginBean}")
	LoginBean login;
	
	String token;
	Integer userId;
	
	UserDTO user;


	public LoginBean getLogin() {
		return login;
	}


	public void setLogin(LoginBean login) {
		this.login = login;
	}


	public UserDTO getUser() {
		return user;
	}


	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
	@PostConstruct
	public void load() {
		
		this.user = login.getUserToken().getUser();
		
	}
	
	
	
	

}
