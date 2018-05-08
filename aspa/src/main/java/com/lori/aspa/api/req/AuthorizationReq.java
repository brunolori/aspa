package com.lori.aspa.api.req;



public class AuthorizationReq {
	
	String fromDate;
	String toDate;
	Integer structureId;
	Integer userId;
	Integer nextUserId;
	Integer fromPlaceId;
	Integer toPlaceId;
	String approved;
	Integer rank;
	boolean status;
	boolean markedForChange;	
	Integer firstResult;
	Integer maxResult;
	
	
	public AuthorizationReq() {}


	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public Integer getStructureId() {
		return structureId;
	}

	public void setStructureId(Integer structureId) {
		this.structureId = structureId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFromPlaceId() {
		return fromPlaceId;
	}

	public void setFromPlaceId(Integer fromPlaceId) {
		this.fromPlaceId = fromPlaceId;
	}

	public Integer getToPlaceId() {
		return toPlaceId;
	}

	public void setToPlaceId(Integer toPlaceId) {
		this.toPlaceId = toPlaceId;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isMarkedForChange() {
		return markedForChange;
	}

	public void setMarkedForChange(boolean markedForChange) {
		this.markedForChange = markedForChange;
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


	public Integer getNextUserId() {
		return nextUserId;
	}


	public void setNextUserId(Integer nextUserId) {
		this.nextUserId = nextUserId;
	}



}
