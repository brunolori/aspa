package com.lori.aspa.ui.services;

import java.util.List;

import com.lori.aspa.ui.clients.UserClient;
import com.lori.aspa.ui.models.Principal;
import com.lori.aspa.ui.models.RoleDTO;
import com.lori.aspa.ui.models.UserDTO;
import com.lori.aspa.ui.models.UserTokenDTO;

public class UserService {

	public UserDTO findUserById(Integer id) {
		return new UserClient().findUserById(id);
	}
	
	public RoleDTO findRoleById(Integer id) {
		return new UserClient().findRoleById(id);
	}

	public UserDTO registerUser(UserDTO user, String token) {
		return new UserClient().registerUser(user, token);
	}

	public UserDTO modifyUser(UserDTO user, String token) {
		return new UserClient().modifyUser(user, token);
	}

	public UserDTO deleteUser(UserDTO user, String token) {
		return new UserClient().deleteUser(user, token);
	}

	public List<UserDTO> searchUser(String token) {
		return new UserClient().searchUser(token);
	}

	public List<UserDTO> queryUser(String nameSurname) {
		return new UserClient().queryUser(nameSurname);
	}

	public UserTokenDTO login(Principal principal) {
		return new UserClient().login(principal);
	}

	public List<RoleDTO> loadRoles() {
		return new UserClient().loadRoles();
	}
	
	public List<UserDTO> loadUsers(){
		
		return new UserClient().loadUsers();
	}
	

}
