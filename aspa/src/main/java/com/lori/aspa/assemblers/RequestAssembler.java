package com.lori.aspa.assemblers;

import com.lori.aspa.api.req.AuthorizationReq;
import com.lori.aspa.api.req.VehicleReq;
import com.lori.aspa.constants.IStatus;
import com.lori.aspa.dao.sql.AuthorizationSQL;
import com.lori.aspa.dao.sql.VehicleSQL;
import com.lori.aspa.utils.DateUtil;

public class RequestAssembler {
	
	
	public AuthorizationSQL toSql(AuthorizationReq req)
	{
		if(req == null) return null;
		
		AuthorizationSQL sql = new AuthorizationSQL();
		
		sql.setDecision(req.getDecision());
		sql.setFirstResult(req.getFirstResult());
		sql.setFromDate(DateUtil.toDate(req.getFromDate()));
		sql.setFromPlaceId(req.getFromPlaceId());
		sql.setMaxResult(req.getMaxResult());
		sql.setNextUserId(req.getNextUserId());
		sql.setStructureId(req.getStructureId());
		sql.setToDate(DateUtil.toDate(req.getToDate()));
		sql.setToPlaceId(req.getToPlaceId());
		sql.setUserId(req.getUserId());
		if(req.getStatus() != null) {
			sql.setStatus(req.getStatus()?IStatus.ACTIVE:IStatus.NOT_ACTIVE);
		}
		
		
		return sql;
	}
	
	
	
	public VehicleSQL toSql(VehicleReq req)
	{
		if(req == null) return null;
		
		VehicleSQL sql = new VehicleSQL();
		sql.setCarriage(req.getCarriage());
		sql.setFirstResult(req.getFirstResult());
		sql.setMaxResult(req.getMaxResult());
		sql.setPlate(req.getPlate());
		sql.setStructureId(req.getStructureId());
		sql.setType(req.getType());
		
		return sql;
		
	}
	

}
