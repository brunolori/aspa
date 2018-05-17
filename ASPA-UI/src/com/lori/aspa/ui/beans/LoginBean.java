package com.lori.aspa.ui.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.lori.aspa.ui.models.Principal;
import com.lori.aspa.ui.models.UserTokenDTO;
import com.lori.aspa.ui.services.UserService;
import com.lori.aspa.ui.utils.Messages;
import com.lori.aspa.ui.utils.StringUtil;
import com.lori.aspa.ui.utils.Util;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	String username;
	String password;
	
	UserTokenDTO userToken;
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserTokenDTO getUserToken() {
		return userToken;
	}

	public void setUserToken(UserTokenDTO userToken) {
		this.userToken = userToken;
	}

	
	
	public void login() {
		
		if(!StringUtil.isValid(username))
		{
			Messages.throwFacesMessage("Plotëso Përdoruesin", 3);
		}
		
		if(!StringUtil.isValid(password))
		{
			Messages.throwFacesMessage("Plotëso Fjalëkalimin", 3);
		}
		
		Principal principal = new Principal();
		principal.setUsername(username);
		principal.setPassword(password);
		
		this.userToken = new UserService().login(principal);
		
		if(userToken != null)
		{
			Util.redirect("sec/my_auth_dashboard");
		}
		else
		{
			Messages.throwFacesMessage("Username/Pasword të gabuara", 3);
		}
		
	}
	
	public void logout() {}
	

}
