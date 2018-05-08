package com.lori.aspa.dao.sql;

import java.util.Date;

public class AuthorizationSQL {

	Date fromDate;
	Date toDate;
	Integer structureId;
	Integer userId;
	Integer nextUserId;
	Integer fromPlaceId;
	Integer toPlaceId;
	String approved;
	String notApproved;
	Integer rank;
	Integer status;
	Integer markedForChange;	
	Integer firstResult;
	Integer maxResult;
	Integer officerId;
	Integer vehicleId;

	
	public AuthorizationSQL() {}


	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getMarkedForChange() {
		return markedForChange;
	}

	public void setMarkedForChange(Integer markedForChange) {
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


	public String getNotApproved() {
		return notApproved;
	}


	public void setNotApproved(String notApproved) {
		this.notApproved = notApproved;
	}


	public Integer getOfficerId() {
		return officerId;
	}


	public void setOfficerId(Integer officerId) {
		this.officerId = officerId;
	}


	public Integer getVehicleId() {
		return vehicleId;
	}


	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}


	
	

}
