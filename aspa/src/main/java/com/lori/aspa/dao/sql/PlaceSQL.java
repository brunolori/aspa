package com.lori.aspa.dao.sql;

import com.lori.aspa.utils.StringUtil;

public class PlaceSQL {
	
	String name;
	Integer municipalityId;
	Integer firstResult;
	Integer maxResult;
	 	
	
	public PlaceSQL(){}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = StringUtil.toUpper(name);
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

	public Integer getMunicipalityId() {
		return municipalityId;
	}

	public void setMunicipalityId(Integer municipalityId) {
		this.municipalityId = municipalityId;
	}
	
	
	
	
	
	
	
	
	

}
