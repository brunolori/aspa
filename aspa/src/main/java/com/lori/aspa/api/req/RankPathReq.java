package com.lori.aspa.api.req;

public class RankPathReq {
	
	
	boolean officerId;
	boolean structureId;
	boolean rank;
	boolean firstResult;
	boolean maxResult;
	
	
	public RankPathReq() {}
	
	public boolean isOfficerId() {
		return officerId;
	}
	public void setOfficerId(boolean officerId) {
		this.officerId = officerId;
	}
	public boolean isStructureId() {
		return structureId;
	}
	public void setStructureId(boolean structureId) {
		this.structureId = structureId;
	}
	public boolean isRank() {
		return rank;
	}
	public void setRank(boolean rank) {
		this.rank = rank;
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
