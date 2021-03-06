package com.lori.aspa.dto;

import java.util.List;



public class UserDTO {


	    private int id;
	    private String username;
	    private String secret;
	    private boolean active;
	    private List<RoleDTO> roles;
	    private OfficerDTO officer;
	    private String registerDate;
	    private String lastUpdate;
	    private int registerUserId;
	    private String registerUser;
	    private int updateUserId;
	    private String updateUser;
	    private boolean finalApproval;
	    
	    
	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getSecret() {
			return secret;
		}
		public void setSecret(String secret) {
			this.secret = secret;
		}
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
		public List<RoleDTO> getRoles() {
			return roles;
		}
		public void setRoles(List<RoleDTO> roles) {
			this.roles = roles;
		}
		public OfficerDTO getOfficer() {
			return officer;
		}
		public void setOfficer(OfficerDTO officer) {
			this.officer = officer;
		}
		public String getRegisterDate() {
			return registerDate;
		}
		public void setRegisterDate(String registerDate) {
			this.registerDate = registerDate;
		}
		public String getLastUpdate() {
			return lastUpdate;
		}
		public void setLastUpdate(String lastUpdate) {
			this.lastUpdate = lastUpdate;
		}
		public int getRegisterUserId() {
			return registerUserId;
		}
		public void setRegisterUserId(int registerUserId) {
			this.registerUserId = registerUserId;
		}
		public String getRegisterUser() {
			return registerUser;
		}
		public void setRegisterUser(String registerUser) {
			this.registerUser = registerUser;
		}
		public int getUpdateUserId() {
			return updateUserId;
		}
		public void setUpdateUserId(int updateUserId) {
			this.updateUserId = updateUserId;
		}
		public String getUpdateUser() {
			return updateUser;
		}
		public void setUpdateUser(String updateUser) {
			this.updateUser = updateUser;
		}
		public boolean isFinalApproval() {
			return finalApproval;
		}
		public void setFinalApproval(boolean finalApproval) {
			this.finalApproval = finalApproval;
		}
	    
   


	    
	    


}
