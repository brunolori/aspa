package com.lori.aspa.api.req;

public class TravelReq {
	
	
	boolean authorizationId;
	boolean firstResult;
	boolean maxResult;
	
	
	public TravelReq() {}
	
	public boolean isAuthorizationId() {
		return authorizationId;
	}
	public void setAuthorizationId(boolean authorizationId) {
		this.authorizationId = authorizationId;
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
