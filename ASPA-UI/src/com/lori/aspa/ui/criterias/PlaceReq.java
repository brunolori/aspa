package com.lori.aspa.ui.criterias;

public class PlaceReq {
	
	String name;
	boolean municipalityId;
	boolean firstResult;
	boolean maxResult;
	
	
	public PlaceReq() {}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isMunicipalityId() {
		return municipalityId;
	}
	public void setMunicipalityId(boolean municipalityId) {
		this.municipalityId = municipalityId;
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
