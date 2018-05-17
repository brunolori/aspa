package com.lori.aspa.ui.clients;

import java.util.List;

import com.lori.aspa.ui.models.Principal;
import com.lori.aspa.ui.models.UserDTO;
import com.lori.aspa.ui.models.UserTokenDTO;

public class UserClient {
	
	public UserDTO findUserById(Integer id) {
		return null;
	}

	public UserDTO registerUser(UserDTO user, String token) {
		return null;
	}

	public UserDTO modifyUser(UserDTO user, String token) {
		return null;
	}

	public UserDTO deleteUser(UserDTO user, String token) {
		return null;
	}

	public List<UserDTO> searchUser(String token) {
		return null;
	}

	public List<UserDTO> queryUser(String nameSurname) {
		return null;
	}

	public UserTokenDTO login(Principal principal) {
		return null;
	}

}
