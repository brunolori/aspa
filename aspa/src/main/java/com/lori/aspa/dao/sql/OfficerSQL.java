package com.lori.aspa.dao.sql;

import java.util.List;

public class OfficerSQL {
	
	Integer rimsId;
	String name;
	String surname;
	Integer status; 
	List<Integer> structuresIdList;
	Integer firstResult;
	Integer maxResult;
	
	
	
	public OfficerSQL() {}


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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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
