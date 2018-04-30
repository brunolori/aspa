/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lori.aspa.dto;



/**
 *
 * @author lorela.shehu
 */

public class ApprovalHistoryDTO {
  
    private int id;
    private String approvalTime;
    private String reason;
    private String decision;
    private int authorizationId;
    private int rank;
    private String structure;
    private int structureId;
    private String user;
    private int userId;
    private boolean active;
    
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApprovalTime() {
		return approvalTime;
	}
	public void setApprovalTime(String approvalTime) {
		this.approvalTime = approvalTime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public int getAuthorizationId() {
		return authorizationId;
	}
	public void setAuthorizationId(int authorizationId) {
		this.authorizationId = authorizationId;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}


    
    
}
