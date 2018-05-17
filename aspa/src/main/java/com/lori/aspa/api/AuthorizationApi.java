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

import com.lori.aspa.api.req.AuthorizationReq;
import com.lori.aspa.dto.ApprovalHistoryDTO;
import com.lori.aspa.dto.AuthorizationDTO;
import com.lori.aspa.exceptions.AppException;
import com.lori.aspa.model.MyDashboardDTO;
import com.lori.aspa.security.TokenUtil;
import com.lori.aspa.services.AuthorizationService;

@RestController
@RequestMapping("/api/authorization")
public class AuthorizationApi {

	@Autowired
	AuthorizationService authorizationService;

	@RequestMapping(value = "/findAuthorization/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> findAuthorization(@PathVariable(name = "id") Integer authorizationId) {
		AuthorizationDTO auth = authorizationService.findAuthorizationById(authorizationId);
		return new ResponseEntity<>(auth, HttpStatus.OK);
	}

	@RequestMapping(value = "/searchAuthorization", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> searchAuthorization(@RequestHeader(value = "Authorization", required = false) String token, @RequestBody AuthorizationReq req) {
		List<AuthorizationDTO> auths = authorizationService.searchAuthorization(req);
		return new ResponseEntity<>(auths, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/myDashboard", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getMyDashboard(@RequestHeader(value = "Authorization", required = false) String token) {
		String uname = TokenUtil.getUsername(token);
		MyDashboardDTO dash = authorizationService.getMydashboard(uname);
		return new ResponseEntity<>(dash, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> registerAuthorization(
			@RequestHeader(value = "Authorization", required = false) String token, @RequestBody AuthorizationDTO dto) {

		try {

			AuthorizationDTO auth = authorizationService.registerAuthorization(dto);
			return new ResponseEntity<>(auth, HttpStatus.OK);

		} catch (AppException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> modifyAuthorization(@RequestHeader(value = "Authorization", required = false) String token,@RequestBody AuthorizationDTO dto) {
		try {
			String uname = TokenUtil.getUsername(token);

			AuthorizationDTO auth = authorizationService.modifyAuthorization(dto, uname);
			return new ResponseEntity<>(auth, HttpStatus.OK);
		} catch (AppException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> delete(@RequestHeader(value = "Authorization", required = false) String token,
			@RequestBody AuthorizationDTO dto) {
		AuthorizationDTO auth = authorizationService.delete(dto);
		return new ResponseEntity<>(auth, HttpStatus.OK);
	}

	@RequestMapping(value = "/decide", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> decide(@RequestHeader(value = "Authorization", required = false) String token,
			@RequestBody ApprovalHistoryDTO dto) {
		String uname = TokenUtil.getUsername(token);
		authorizationService.decide(dto, uname);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
