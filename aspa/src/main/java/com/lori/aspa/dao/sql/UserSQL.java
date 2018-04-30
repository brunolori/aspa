package com.lori.aspa.dao.sql;

import com.lori.aspa.utils.StringUtil;

public class UserSQL {

	String username;
	String name;
	String surname;
	Integer status;
	Integer structureId;
	Integer firstResult;
	Integer maxResult;
	
	public UserSQL() {}
	
	public UserSQL(String username) {
		setUsername(username);
		this.maxResult = 1;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = StringUtil.toUpper(username);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = StringUtil.toUpper(name);
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = StringUtil.toUpper(surname);
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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
