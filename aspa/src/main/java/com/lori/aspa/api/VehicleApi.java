package com.lori.aspa.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lori.aspa.api.req.VehicleReq;
import com.lori.aspa.dto.UserDTO;
import com.lori.aspa.dto.VehicleDTO;
import com.lori.aspa.security.TokenUtil;
import com.lori.aspa.services.UserService;
import com.lori.aspa.services.VehicleService;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleApi {
	
	@Autowired
	VehicleService vehicleService;
	@Autowired
	UserService userService;
	
	
	
	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> findUserById(@PathVariable(name = "id") Integer id) {
		VehicleDTO v = vehicleService.findVehicleById(id);
		return new ResponseEntity<>(v, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getUserVehicles", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> loadUserVehicles(@RequestHeader(value = "Authorization", required = false) String token) {

		String uname = TokenUtil.getUsername(token);
		UserDTO u = userService.findUserByUsername(uname);
		
		List<VehicleDTO> v = vehicleService.searchVehicle(new VehicleReq());
		
		return new ResponseEntity<>(v, HttpStatus.OK);
	}
	
	

}
