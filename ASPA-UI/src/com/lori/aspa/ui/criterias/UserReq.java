package com.lori.aspa.ui.criterias;

public class UserReq {
	
	
	String username;
	String name;
	String surname;
	boolean status;
	Integer structureId;
	Integer firstResult;
	Integer maxResult;
	
	
	public UserReq() {}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Integer getStructureId() {
		return structureId;
	}

	public void setStructureId(Integer structureId) {
		this.structureId = structureId;
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
