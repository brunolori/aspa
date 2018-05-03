package com.lori.aspa.dao.sql;

public class RankPathSQL {

	
	Integer officerId;
	Integer structureId;
	Integer rank;
	Integer firstResult;
	Integer maxResult;
 
	public RankPathSQL() {}

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

	public Integer getOfficerId() {
		return officerId;
	}

	public void setOfficerId(Integer officerId) {
		this.officerId = officerId;
	}

	public Integer getStructureId() {
		return structureId;
	}

	public void setStructureId(Integer structureId) {
		this.structureId = structureId;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	
	
	
}
