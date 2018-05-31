package com.lori.aspa.ui.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.lori.aspa.ui.clients.ApiException;
import com.lori.aspa.ui.models.OfficerDTO;
import com.lori.aspa.ui.models.RoleDTO;
import com.lori.aspa.ui.models.UserDTO;
import com.lori.aspa.ui.services.OfficerService;
import com.lori.aspa.ui.services.UserService;
import com.lori.aspa.ui.utils.Messages;

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

	String name;
	String surname;
	List<OfficerDTO> officers;
	OfficerDTO selectedOfficer;

	boolean disableUser;

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

	public List<OfficerDTO> getOfficers() {
		return officers;
	}

	public void setOfficers(List<OfficerDTO> officers) {
		this.officers = officers;
	}

	public OfficerDTO getSelectedOfficer() {
		return selectedOfficer;
	}

	public void setSelectedOfficer(OfficerDTO selectedOfficer) {
		this.selectedOfficer = selectedOfficer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public boolean isDisableUser() {
		return disableUser;
	}

	public void setDisableUser(boolean disableUser) {
		this.disableUser = disableUser;
	}
	
	

	@PostConstruct
	public void load() {

		this.userId = login.getUserToken().getUser().getId();
		this.token = login.getUserToken().getToken();

		init();
		goToUserList();
		this.roles = new UserService().loadRoles();

	}

	private void init() {
		this.user = new UserDTO();
		this.officer = new OfficerDTO();
		this.selectedUser = null;
		this.selectedRoles = null;
		this.users = new UserService().loadUsers();
		this.selectedOfficer = null;
		this.officers = null;
		this.name = null;
		this.surname = null;
		this.disableUser = true;
	}

	public void clearSearchOfficer()
	{
		//this.officer = new OfficerDTO();
		this.selectedOfficer = null;
		this.officers = null;
		this.name = null;
		this.surname = null;
	}
	
	public void clearUser()
	{
		this.selectedOfficer = null;
		this.officer = new OfficerDTO();
		this.user = new UserDTO();
		this.disableUser = true;
	}
	
	public void clear() {

		init();

	}

	public void searchOfficer() {

		this.officers = new OfficerService().searchOfficer(name, surname);
		this.selectedOfficer = null;
		//this.officer = new OfficerDTO();
	}

	public void onUserSelect() {
		this.user = selectedUser;
		this.selectedRoles = user.getRoles();
		this.activePage = "/sec/user_modify.xhtml";
	}

	public void onOfficerSelect() {
		this.officer = selectedOfficer;
		this.disableUser = false;
	}

	public void goToUserCreate() {
		this.user = new UserDTO();
		this.officer = new OfficerDTO();
		this.selectedRoles = new ArrayList<>();
		this.activePage = "/sec/user_create.xhtml";
	}

	public void goToUserList() {
		this.activePage = "/sec/user_list.xhtml";
	}

	public void create() {
		try {
			
			System.err.println(selectedRoles);
			
			this.user.setOfficer(officer);
			this.user.setRoles(selectedRoles);
			new UserService().registerUser(user, token);
			Messages.throwFacesMessage("Punonjësi u regjistrua me sukses", 1);
			init();
			goToUserList();
		} catch (ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}

	public void modify() {
		try {
			this.user.setRoles(selectedRoles);
			new UserService().modifyUser(user, token);
			Messages.throwFacesMessage("Punonjësi u modifikua me sukses", 1);
			init();
			goToUserList();
		} catch (ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}

}
