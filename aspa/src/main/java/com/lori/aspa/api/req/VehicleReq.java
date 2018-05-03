package com.lori.aspa.api.req;

public class VehicleReq {
	
	
	String plate;
	String carriage;
	String type;
	boolean structureId;
	boolean firstResult;
	boolean maxResult;
	
	
	public VehicleReq() {}
	
	
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
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
	public boolean isStructureId() {
		return structureId;
	}
	public void setStructureId(boolean structureId) {
		this.structureId = structureId;
	}
	public boolean isFirstResult() {
		return firstResult;
	}
	public void setFirstResult(boolean firstResult) {
		this.firstResult = firstResult;
	}
	public boolean isMaxResult() {
		return maxResult;
	}
	public void setMaxResult(boolean maxResult) {
		this.maxResult = maxResult;
	}
	
	
	
	

}
