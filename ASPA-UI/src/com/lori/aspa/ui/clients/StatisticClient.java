package com.lori.aspa.ui.clients;

import java.util.Date;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.lori.aspa.ui.constants.IApiClient;
import com.lori.aspa.ui.models.OfficerCount;
import com.lori.aspa.ui.models.OfficerDTO;
import com.lori.aspa.ui.models.Principal;
import com.lori.aspa.ui.models.UserTokenDTO;
import com.lori.aspa.ui.models.ValuePair;
import com.lori.aspa.ui.utils.DateUtil;
import com.lori.aspa.ui.utils.StringUtil;

public class StatisticClient {

	public long countAllAuths(Date fromDate, Date toDate, String decision, Integer structureId, String token) {
		final String BASE_URL = IApiClient.SERVER + "/api/statistic/countAllAuths";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		builder.queryParam("from", DateUtil.formatDate(fromDate));
		builder.queryParam("to", DateUtil.formatDate(toDate));
		if (StringUtil.isValid(decision)) {
			builder.queryParam("decision", decision);
		}
		if (structureId != null) {
			builder.queryParam("structureId", structureId);
		}

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);

		ResponseEntity<Long> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				Long.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return 0;
	}

	public long countActiveServices(Integer structureId, String token) {

		final String BASE_URL = IApiClient.SERVER + "/api/statistic/countActiveServices";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		builder.queryParam("structureId", structureId);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);

		ResponseEntity<Long> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				Long.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return 0;

	}

	public long countOfficersInService(Integer structureId, String token) {

		final String BASE_URL = IApiClient.SERVER + "/api/statistic/countOfficersInService";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		builder.queryParam("structureId", structureId);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);

		ResponseEntity<Long> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				Long.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return 0;

	}

	public long countVehiclesInService(Integer structureId, String token) {

		final String BASE_URL = IApiClient.SERVER + "/api/statistic/countVehiclesInService";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		builder.queryParam("structureId", structureId);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);

		ResponseEntity<Long> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				Long.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return 0;

	}

	public List<ValuePair> getOfficersInServiceByDate(Date fromDate, Date toDate, Integer structureId, String token) {

		final String BASE_URL = IApiClient.SERVER + "/api/statistic/getOfficersInServiceByDate";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		builder.queryParam("from", DateUtil.formatDate(fromDate));
		builder.queryParam("to", DateUtil.formatDate(toDate));
		builder.queryParam("structureId", structureId);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);

		ParameterizedTypeReference<List<ValuePair>> typeRef = new ParameterizedTypeReference<List<ValuePair>>() {
		};

		ResponseEntity<List<ValuePair>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				typeRef);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;

	}

	public List<ValuePair> countAuthorizationsByMonth(Integer year, Integer structureId, String token) {

		final String BASE_URL = IApiClient.SERVER + "/api/statistic/countAuthorizationsByMonth";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		builder.queryParam("structureId", structureId);
		builder.queryParam("year", year);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);

		ParameterizedTypeReference<List<ValuePair>> typeRef = new ParameterizedTypeReference<List<ValuePair>>() {
		};

		ResponseEntity<List<ValuePair>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				typeRef);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;

	}

	public List<OfficerCount> getOfficersByServiceNo(Date fromDate, Date toDate, Integer structureId, String token) {

		final String BASE_URL = IApiClient.SERVER + "/api/statistic/officersByServiceNo";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		builder.queryParam("from", DateUtil.formatDate(fromDate));
		builder.queryParam("to", DateUtil.formatDate(toDate));
		builder.queryParam("structureId", structureId);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", token);
		HttpEntity<?> entity = new HttpEntity<>(headers);

		ParameterizedTypeReference<List<OfficerCount>> typeRef = new ParameterizedTypeReference<List<OfficerCount>>() {
		};

		ResponseEntity<List<OfficerCount>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,
				entity, typeRef);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;

	}

	public static void main(String[] args) {
		StatisticClient c = new StatisticClient();
		UserClient u = new UserClient();

		UserTokenDTO k = u.login(new Principal("bruno", "1234"));

		List<OfficerCount> list = c.getOfficersByServiceNo(DateUtil.toDate("01.05.2018"), DateUtil.toDate("30.06.2018"),
				null, k.getToken());

		System.out.println("STATISTIC:..... ");
		for (OfficerCount p : list) {
			OfficerDTO o = p.getOfficer();
			int v = (int) p.getCount();

			System.out.println("O_ID: " + o.fullName() + "\t NO:" + v);
		}
	}

}
