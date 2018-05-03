package com.lori.aspa.api.req;

public class UserReq {
	
	
	String username;
	String name;
	String surname;
	boolean status;
	boolean structureId;
	boolean firstResult;
	boolean maxResult;
	
	
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
	public boolean isStructureId() {
		return structureId;
	}
	public void setStructureId(boolean structureId) {
		this.structureId = structureId;
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
