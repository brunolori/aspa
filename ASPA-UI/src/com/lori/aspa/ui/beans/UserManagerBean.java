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
import com.lori.aspa.ui.services.UserService;

@ManagedBean
@ViewScoped
public class UserManagerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{loginBean}")
	LoginBean login;

	String token;
	Integer userId;

	List<UserDTO> users;
	UserDTO user;
	OfficerDTO officer;
	UserDTO selectedUser;
	List<RoleDTO> selectedRoles;
	List<RoleDTO> roles;
	String activePage;
	
	

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

	public UserDTO getSelectedUser() {
		return selectedUser;
	}
	public void setSelectedUser(UserDTO selectedUser) {
		this.selectedUser = selectedUser;
	}
	public String getActivePage() {
		return activePage;
	}
	public void setActivePage(String activePage) {
		this.activePage = activePage;
	}
	public List<RoleDTO> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}
	public List<RoleDTO> getSelectedRoles() {
		return selectedRoles;
	}
	public void setSelectedRoles(List<RoleDTO> selectedRoles) {
		this.selectedRoles = selectedRoles;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	public OfficerDTO getOfficer() {
		return officer;
	}
	public void setOfficer(OfficerDTO officer) {
		this.officer = officer;
	}
	
	
	@PostConstruct
	public void load() {
		
		this.userId = login.getUserToken().getUser().getId();
		this.token = login.getUserToken().getToken();
		
	    init();
	    goToUserList();
		this.roles = new UserService().loadRoles();

	}

	private void init()
	{
		this.user = new UserDTO();
		this.officer = new OfficerDTO();
		this.selectedUser = null;
		this.selectedRoles = null;
		this.users = new UserService().loadUsers();
	}
	
	
	public void onUserSelect() {
		this.user = selectedUser;
		this.selectedRoles = user.getRoles();
		this.activePage = "/sec/user_modify.xhtml";
	}
		
	public void goToUserCreate() {
		this.user = new UserDTO();
		this.officer = new OfficerDTO();
		this.activePage = "/sec/user_create.xhtml";
	}
	
	public void goToUserList() 
	{
		this.activePage = "/sec/user_list.xhtml";
	}
	
	public void modify()
	{
		
	}
	
	public void create()
	{
		
	}
	
	
	
	
}
