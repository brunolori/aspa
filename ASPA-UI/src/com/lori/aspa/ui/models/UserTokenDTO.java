package com.lori.aspa.ui.models;

import java.io.Serializable;

public class UserTokenDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	UserDTO user;
	String token;
	
	
	public UserTokenDTO() {}
	
	
	public UserTokenDTO(UserDTO user, String token) {
		super();
		this.user = user;
		this.token = token;
	}
	
	
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	

}
