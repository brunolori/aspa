package com.lori.aspa.api;

import java.util.ArrayList;
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

import com.lori.aspa.dto.StructureDTO;
import com.lori.aspa.dto.UserDTO;
import com.lori.aspa.exceptions.AppException;
import com.lori.aspa.security.TokenUtil;
import com.lori.aspa.services.StructureService;
import com.lori.aspa.services.UserService;

@RestController
@RequestMapping("/api/structure")
public class StructureApi {

	
	@Autowired
	StructureService structureService;
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/findStructure/{id}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> findStructure(@PathVariable(name="id") Integer structureId)
	{
		StructureDTO str = structureService.findStructureById(structureId);
		return new ResponseEntity<>(str,HttpStatus.OK);
	}
	
	@RequestMapping(value="/loadChildStructures/{id}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> loadChildStructures(@PathVariable(name="id") Integer structureId)
	{
		List<StructureDTO> list = structureService.getStructureChilds(structureId);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value="/userStructures/{userId}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> loadUserStructures(@RequestHeader(value = "Authorization") String token, @PathVariable(name="userId") Integer userId)
	{
		String uname = TokenUtil.getUsername(token);
		
		UserDTO u = userService.findUserByUsername(uname);
		StructureDTO str = structureService.findStructureById(u.getOfficer().getStructureId());
		List<StructureDTO> list = structureService.getStructureChilds(str.getId());
		if(list == null) list = new ArrayList<>();
		list.add(str);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> registerStructure(@RequestHeader(value = "Authorization") String token, @RequestBody StructureDTO dto) {

		try {

			String uname = TokenUtil.getUsername(token);
						
			StructureDTO str = structureService.registerStructure(dto, uname);
			return new ResponseEntity<>(str, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}

	}
	
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> modifyStructure(@RequestHeader(value = "Authorization") String token, @RequestBody StructureDTO dto) {

		try {

			String uname = TokenUtil.getUsername(token);
			
			StructureDTO str = structureService.modifyStructure(dto, uname);
			return new ResponseEntity<>(str, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}

	}
	
	
	@RequestMapping(value = "/loadStructures", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> loadStructures()
	{
		List<StructureDTO> str = structureService.loadStructures();
		return new ResponseEntity<>(str, HttpStatus.OK);
	}

	
	
}
