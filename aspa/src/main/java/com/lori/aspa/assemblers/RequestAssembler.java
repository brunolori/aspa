package com.lori.aspa.assemblers;

import com.lori.aspa.api.req.VehicleReq;
import com.lori.aspa.dao.sql.VehicleSQL;

public class RequestAssembler {
	
	
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
