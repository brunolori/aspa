package com.lori.aspa.dto;





public class PlaceDTO {
	
	
	
	private int id;
    private String name;
    private boolean active;
    private String municipality;
    private int municipalityId;
    

    
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getMunicipality() {
		return municipality;
	}
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	public int getMunicipalityId() {
		return municipalityId;
	}
	public void setMunicipalityId(int municipalityId) {
		this.municipalityId = municipalityId;
	}


    
    


}
