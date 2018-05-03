package com.lori.aspa.api.req;



public class AuthorizationReq {
	
	String fromDate;
	String toDate;
	boolean structureId;
	boolean userId;
	boolean fromPlaceId;
	boolean toPlaceId;
	boolean approved;
	boolean canceled;
	boolean rank;
	boolean status;
	boolean markedForChange;	
	boolean firstResult;
	boolean maxResult;
	
	
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

	public boolean isStructureId() {
		return structureId;
	}

	public void setStructureId(boolean structureId) {
		this.structureId = structureId;
	}

	public boolean isUserId() {
		return userId;
	}

	public void setUserId(boolean userId) {
		this.userId = userId;
	}

	public boolean isFromPlaceId() {
		return fromPlaceId;
	}

	public void setFromPlaceId(boolean fromPlaceId) {
		this.fromPlaceId = fromPlaceId;
	}

	public boolean isToPlaceId() {
		return toPlaceId;
	}

	public void setToPlaceId(boolean toPlaceId) {
		this.toPlaceId = toPlaceId;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	public boolean isRank() {
		return rank;
	}

	public void setRank(boolean rank) {
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
