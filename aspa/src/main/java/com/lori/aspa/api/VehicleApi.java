package com.lori.aspa.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lori.aspa.api.req.VehicleReq;
import com.lori.aspa.dto.UserDTO;
import com.lori.aspa.dto.VehicleDTO;
import com.lori.aspa.dto.VehicleTypeDTO;
import com.lori.aspa.exceptions.AppException;
import com.lori.aspa.security.TokenUtil;
import com.lori.aspa.services.StructureService;
import com.lori.aspa.services.UserService;
import com.lori.aspa.services.VehicleService;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleApi {
	
	@Autowired
	VehicleService vehicleService;
	@Autowired
	UserService userService;
	@Autowired
	StructureService structureService;
	
	
	
	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> findUserById(@PathVariable(name = "id") Integer id) {
		VehicleDTO v = vehicleService.findVehicleById(id);
		return new ResponseEntity<>(v, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getUserVehicles", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> loadUserVehicles(@RequestHeader(value = "Authorization") String token) {

		String uname = TokenUtil.getUsername(token);
		UserDTO u = userService.findUserByUsername(uname);

		VehicleReq r = new VehicleReq();
		r.setStructureId(u.getOfficer().getStructureId());
		List<VehicleDTO> v = vehicleService.searchVehicle(r);
		
		return new ResponseEntity<>(v, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/loadVehicleTypes", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> loadVehicleTypes()
	{
		List<VehicleTypeDTO> vt = vehicleService.loadVehicleTypes();
		return new ResponseEntity<>(vt, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> registerVehicle(@RequestHeader(value = "Authorization") String token, @RequestBody VehicleDTO dto) {

		try {

			String uname = TokenUtil.getUsername(token);
			
			VehicleDTO vehicle = vehicleService.registerVehicle(dto, uname);
			return new ResponseEntity<>(vehicle, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}

	}
	
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> modifyVehicle(@RequestHeader(value = "Authorization") String token, @RequestBody VehicleDTO dto) {

		try {

			String uname = TokenUtil.getUsername(token);
			
			VehicleDTO vehicle = vehicleService.modifyVehicle(dto, uname);
			return new ResponseEntity<>(vehicle, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}

	}
	
	

}
