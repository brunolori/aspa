package com.lori.aspa.ui.criterias;

import java.util.List;

public class OfficerReq {
	
	Integer rimsId;
	String name;
	String surname;
	boolean status; 
	List<Integer> structuresIdList;
	Integer firstResult;
	Integer maxResult;
	
	
	public OfficerReq() {}


	public Integer getRimsId() {
		return rimsId;
	}

	public void setRimsId(Integer rimsId) {
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
