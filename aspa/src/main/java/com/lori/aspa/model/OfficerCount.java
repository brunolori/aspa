package com.lori.aspa.model;

import com.lori.aspa.assemblers.Assembler;
import com.lori.aspa.dto.OfficerDTO;
import com.lori.aspa.entities.Officer;

public class OfficerCount {

	OfficerDTO officer;
	long count;
	
	public OfficerCount(long count, Officer o)
	{
		this.count = count;
		this.officer = new Assembler().toDto(o);
	}
	
	
	
	public OfficerDTO getOfficer() {
		return officer;
	}
	public void setOfficer(OfficerDTO officer) {
		this.officer = officer;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	
	
	
	
	
	
	
}
