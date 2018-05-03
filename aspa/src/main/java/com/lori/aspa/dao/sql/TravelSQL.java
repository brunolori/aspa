package com.lori.aspa.dao.sql;

public class TravelSQL {
	
	Integer authorizationId;
	Integer firstResult;
	Integer maxResult;
	 
	
	public  TravelSQL() {}
	
	
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


	public Integer getAuthorizationId() {
		return authorizationId;
	}


	public void setAuthorizationId(Integer authorizationId) {
		this.authorizationId = authorizationId;
	}
	

}
