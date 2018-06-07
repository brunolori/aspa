package com.lori.aspa.api;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.lori.aspa.dto.UserDTO;
import com.lori.aspa.exceptions.AppException;
import com.lori.aspa.model.MyDashboardDTO;
import com.lori.aspa.security.TokenUtil;
import com.lori.aspa.services.AuthorizationService;
import com.lori.aspa.services.PdfExporter;
import com.lori.aspa.services.UserService;

@RestController
@RequestMapping("/api/authorization")
public class AuthorizationApi {

	@Autowired
	AuthorizationService authorizationService;
	@Autowired
	UserService userService;
	@Autowired
	PdfExporter pdfExporter;

	@RequestMapping(value = "/findAuthorization/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> findAuthorization(@PathVariable(name = "id") Integer authorizationId) {
		AuthorizationDTO auth = authorizationService.findAuthorizationById(authorizationId);
		if (auth == null) {
			return new ResponseEntity<String>(new String("Nuk u gjend autorizimi"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(auth, HttpStatus.OK);
	}

	@RequestMapping(value = "/searchAuthorization", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> searchAuthorization(@RequestHeader(value = "Authorization") String token,
			@RequestBody AuthorizationReq req) {

		List<AuthorizationDTO> auths = authorizationService.searchAuthorization(req);
		return new ResponseEntity<>(auths, HttpStatus.OK);
	}

	@RequestMapping(value = "/myDashboard", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getMyDashboard(@RequestHeader(value = "Authorization") String token) {
		String uname = TokenUtil.getUsername(token);
		MyDashboardDTO dash = authorizationService.getMydashboard(uname);
		return new ResponseEntity<>(dash, HttpStatus.OK);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> registerAuthorization(@RequestHeader(value = "Authorization") String token,
			@RequestBody AuthorizationDTO dto) {

		try {

			String uname = TokenUtil.getUsername(token);
			UserDTO u = userService.findUserByUsername(uname);
			dto.setUserId(u.getId());

			AuthorizationDTO auth = authorizationService.registerAuthorization(dto);
			return new ResponseEntity<>(auth, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> modifyAuthorization(@RequestHeader(value = "Authorization") String token,
			@RequestBody AuthorizationDTO dto) {
		try {
			String uname = TokenUtil.getUsername(token);

			AuthorizationDTO auth = authorizationService.modifyAuthorization(dto, uname);
			return new ResponseEntity<>(auth, HttpStatus.OK);
		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> delete(@RequestHeader(value = "Authorization") String token,
			@RequestBody AuthorizationDTO dto) {
		AuthorizationDTO auth = authorizationService.delete(dto);
		return new ResponseEntity<>(auth, HttpStatus.OK);
	}

	@RequestMapping(value = "/decide", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> decide(@RequestHeader(value = "Authorization") String token,
			@RequestBody ApprovalHistoryDTO dto) {
		try {
			String uname = TokenUtil.getUsername(token);
			authorizationService.decide(dto, uname);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/getAuthHistory/{auth_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getVerifiedAuths(@RequestHeader(value = "Authorization") String token,
			@PathVariable(name = "auth_id") Integer authId) {

		List<ApprovalHistoryDTO> histories = authorizationService.getAuthHistory(authId);
		return new ResponseEntity<>(histories, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAuthorizationsToVerify", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getAuthsToVerify(@RequestHeader(value = "Authorization") String token) {

		String uname = TokenUtil.getUsername(token);

		List<AuthorizationDTO> auths = authorizationService.getAuthsToVerify(uname);
		return new ResponseEntity<>(auths, HttpStatus.OK);
	}

	@RequestMapping(value = "/getVerifiedAuths", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getVerifiedAuths(@RequestHeader(value = "Authorization") String token) {

		String uname = TokenUtil.getUsername(token);

		List<AuthorizationDTO> auths = authorizationService.getVerifiedAuths(uname);
		return new ResponseEntity<>(auths, HttpStatus.OK);
	}

	
	
	@RequestMapping(value = "/pdfAuth/{auth_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> pdfExporter(@PathVariable(name = "auth_id") Integer authorizationId) throws IOException {
		
		AuthorizationDTO authorization = authorizationService.findAuthorizationById(authorizationId);
		
        InputStream bis = pdfExporter.authorizationPdf(authorization);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=authorization.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
	
	
	
	
}
