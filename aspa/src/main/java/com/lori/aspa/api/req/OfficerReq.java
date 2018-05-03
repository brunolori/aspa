package com.lori.aspa.api.req;

import java.util.List;

public class OfficerReq {
	
	boolean rimsId;
	String name;
	String surname;
	boolean status; 
	List<Integer> structuresIdList;
	boolean firstResult;
	boolean maxResult;
	
	
	public OfficerReq() {}
	
	
	public boolean isRimsId() {
		return rimsId;
	}
	public void setRimsId(boolean rimsId) {
		this.rimsId = rimsId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<Integer> getStructuresIdList() {
		return structuresIdList;
	}
	public void setStructuresIdList(List<Integer> structuresIdList) {
		this.structuresIdList = structuresIdList;
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
