package com.lori.aspa.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lori.aspa.model.ValuePair;
import com.lori.aspa.security.TokenUtil;
import com.lori.aspa.services.StatisticService;
import com.lori.aspa.utils.DateUtil;

@RestController
@RequestMapping("/api/statistic")
public class StatisticApi {

	@Autowired
	StatisticService statisticService;

	@RequestMapping(value = "/countAllAuths", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> countAllAuths(@RequestHeader(value = "Authorization") String token,
			@RequestParam(name = "from") String fromDate, @RequestParam(name = "to") String toDate,
			@RequestParam(name = "decision") String decision, @RequestParam(name = "structureId") Integer structureId) {

		String uname = TokenUtil.getUsername(token);

		long d = statisticService.countAllAuths(DateUtil.toDate(fromDate), DateUtil.toDate(toDate), decision,
				structureId, uname);
		return new ResponseEntity<>(d, HttpStatus.OK);
	}

	@RequestMapping(value = "/countActiveServices", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> countActiveServices(@RequestHeader(value = "Authorization") String token,
			@RequestParam(name = "structureId") Integer structureId) {

		String uname = TokenUtil.getUsername(token);

		long d = statisticService.countActiveServices(structureId, uname);
		return new ResponseEntity<>(d, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/countOfficersInService", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> countOfficersInService(@RequestHeader(value = "Authorization") String token,
			@RequestParam(name = "structureId") Integer structureId) {

		String uname = TokenUtil.getUsername(token);

		long d = statisticService.countOfficersInService(structureId, uname);
		return new ResponseEntity<>(d, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/countVehiclesInService", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> countVehiclesInService(@RequestHeader(value = "Authorization") String token,
			@RequestParam(name = "structureId") Integer structureId) {

		String uname = TokenUtil.getUsername(token);

		long d = statisticService.countVehiclesInService(structureId, uname);
		return new ResponseEntity<>(d, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getOfficersInServiceByDate", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getOfficersInServiceByDate(@RequestHeader(value = "Authorization") String token,
			@RequestParam(name = "from") String fromDate, @RequestParam(name = "to") String toDate,
		     @RequestParam(name = "structureId") Integer structureId) {

		String uname = TokenUtil.getUsername(token);

		List<ValuePair> d = statisticService.getOfficersInServiceByDate(DateUtil.toDate(fromDate), DateUtil.toDate(toDate),structureId, uname);
			
		return new ResponseEntity<>(d, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/countAuthorizationsByMonth", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> countAuthorizationsByMonth(@RequestHeader(value = "Authorization") String token,
			 @RequestParam(name = "year") Integer year,
		     @RequestParam(name = "structureId") Integer structureId) {

		String uname = TokenUtil.getUsername(token);

		List<ValuePair> d = statisticService.countAuthorizationsByMonth(year, structureId, uname);
			
		return new ResponseEntity<>(d, HttpStatus.OK);
	}
	
	
	
	
	

}
