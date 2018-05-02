package com.lori.aspa.dao.sql;

public class PlaceSQL {
	
	String name;
	Integer firstResult;
	Integer maxResult;
	
	
	public PlaceSQL(String name) {
		setName(name);
		this.maxResult = 1;
	}
	
	public PlaceSQL(){}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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
