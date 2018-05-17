package com.lori.aspa.ui.models;


public class OfficerDTO {
	
	
    private int id;
    private String name;
    private String surname;
    private String position;
    private String function;
    private String grade;
    private boolean active;
    private String structure;
    private int structureId;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	public int getStructureId() {
		return structureId;
	}
	public void setStructureId(int structureId) {
		this.structureId = structureId;
	}
	
	public String fullName()
	{
		return name+" "+surname;
	}
    
    
}
