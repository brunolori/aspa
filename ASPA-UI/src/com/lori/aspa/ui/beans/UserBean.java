package com.lori.aspa.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.lori.aspa.ui.models.OfficerDTO;
import com.lori.aspa.ui.models.RoleDTO;
import com.lori.aspa.ui.models.UserDTO;

@ManagedBean
@ViewScoped
public class UserBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{loginBean}")
	LoginBean login;

	String token;
	Integer userId;
	
	
	List<UserDTO> users;
	List<RoleDTO> roles;
	List<OfficerDTO> officers;
	
	UserDTO user;
	UserDTO selectedUser;
	

	
	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}

	public List<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}

	public List<OfficerDTO> getOfficers() {
		return officers;
	}

	public void setOfficers(List<OfficerDTO> officers) {
		this.officers = officers;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public UserDTO getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserDTO selectedUser) {
		this.selectedUser = selectedUser;
	}
	
	
	
	

	@PostConstruct
	public void load() {
		this.userId = login.getUserToken().getUser().getId();
		this.token = login.getUserToken().getToken();

		init();
	}

	private void init() {
		this.user = new UserDTO();
		this.selectedUser = null;
		//this.roles = new UserService().loadRoles();

	}

	public void clear() {
		init();
	}
	
	
	public void onUserSelected() {
		this.user = selectedUser;
	}
	
	
	public void register() {}
	public void modify() {}
	public void delete() {}

}
