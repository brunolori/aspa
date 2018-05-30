package com.lori.aspa.ui.services;

import java.util.Date;
import java.util.List;

import com.lori.aspa.ui.clients.StatisticClient;
import com.lori.aspa.ui.models.ValuePair;

public class StatisticService {

	public long countAllAuths(Date fromDate, Date toDate, String decision, Integer structureId, String token) {
		return new StatisticClient().countAllAuths(fromDate, toDate, decision, structureId, token);
	}

	public long countActiveServices(Integer structureId, String token) {

		return new StatisticClient().countActiveServices(structureId, token);
	}

	public long countOfficersInService(Integer structureId, String token) {

		return new StatisticClient().countOfficersInService(structureId, token);
	}

	public long countVehiclesInService(Integer structureId, String token) {
		return new StatisticClient().countVehiclesInService(structureId, token);
	}

	public List<ValuePair> getOfficersInServiceByDate(Date fromDate, Date toDate, Integer structureId, String token) {

		return new StatisticClient().getOfficersInServiceByDate(fromDate, toDate, structureId, token);
	}

	public List<ValuePair> countAuthorizationsByMonth(Integer year, Integer structureId, String token) {

		return new StatisticClient().countAuthorizationsByMonth(year, structureId, token);
	}

}
