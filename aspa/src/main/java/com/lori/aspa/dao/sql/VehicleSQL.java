package com.lori.aspa.dao.sql;

import com.lori.aspa.utils.StringUtil;

public class VehicleSQL {

	String plate;
	String carriage;
	String type;
	Integer structureId;
	Integer firstResult;
	Integer maxResult;

	public VehicleSQL() {}


	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = StringUtil.toUpper(plate);
	}

	public String getCarriage() {
		return carriage;
	}

	public void setCarriage(String carriage) {
		this.carriage = carriage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getStructureId() {
		return structureId;
	}

	public void setStructureId(Integer structureId) {
		this.structureId = structureId;
	}

	public Integer getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(Integer firstResult) {
		this.firstResult = firstResult;
	}

	public Integer getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}
	
	
	
	
	

}
