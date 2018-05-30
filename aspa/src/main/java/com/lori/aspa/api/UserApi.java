package com.lori.aspa.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lori.aspa.dto.RoleDTO;
import com.lori.aspa.dto.UserDTO;
import com.lori.aspa.model.Principal;
import com.lori.aspa.model.UserTokenDTO;
import com.lori.aspa.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserApi {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> login(@RequestBody Principal principal)
	{
		UserTokenDTO ut = userService.login(principal);
		return new ResponseEntity<>(ut, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> findUserById(@PathVariable(name = "id") Integer userId) {
		UserDTO u = userService.findUserById(userId);
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findRoleById/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> findRoleById(@PathVariable(name = "id") Integer roleId) {
		RoleDTO u = userService.findRoleById(roleId);
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
		
	@RequestMapping(value = "/findByUsername/{uname}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> findUserById(@PathVariable(name = "uname") String uname) {
		UserDTO u = userService.findUserByUsername(uname);
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/queryUser", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> queryUser(@RequestParam(name = "query") String query) {
		List<UserDTO> u = userService.queryUser(query);
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/loadRoles", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> loadRoles()
	{
		List<RoleDTO> r = userService.loadRoles();
		return new ResponseEntity<>(r, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/loadUsers", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> loadUsers()
	{
		List<UserDTO> u = userService.loadUsers();
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
	
}
