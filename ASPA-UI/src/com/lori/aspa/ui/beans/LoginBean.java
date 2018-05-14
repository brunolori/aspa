package com.lori.aspa.ui.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.lori.aspa.ui.models.UserTokenDTO;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	String username;
	String password;
	
	UserTokenDTO userToken;
	
	
	
	 public void login() {
		
              	           
	    }
	
	
	

}
