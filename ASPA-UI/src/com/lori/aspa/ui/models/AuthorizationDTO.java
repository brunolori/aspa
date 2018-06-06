package com.lori.aspa.ui.models;

import java.util.List;

public class AuthorizationDTO {

	    private Integer id;
	    private String fromPlace;
	    private Integer fromPlaceId;
	    private String toPlace;
	    private Integer toPlaceId;
	    private String fromDate;
	    private String toDate;
	    private Integer rank;
	    private String decision;
	    private String finalApprovedDate;
	    private String cancelDate;
	    private String reasonOfTravel;
	    private String structure;
	    private Integer structureId;
	    private String user;
	    private Integer userId;
	    private String authorizationDate;
	    private boolean active;
	    private Integer nextUserId;
	    private String nextUser;
	    private String nextStructure;
	    List<OfficerDTO> officers;
	    List<TravelDTO> travels;
	    List<VehicleDTO> vehicles;
	    String serviceObjectives;
	    String serviceRaporting;
	    
	    
	    
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getFromPlace() {
			return fromPlace;
		}
		public void setFromPlace(String fromPlace) {
			this.fromPlace = fromPlace;
		}
		public Integer getFromPlaceId() {
			return fromPlaceId;
		}
		public void setFromPlaceId(Integer fromPlaceId) {
			this.fromPlaceId = fromPlaceId;
		}
		public String getToPlace() {
			return toPlace;
		}
		public void setToPlace(String toPlace) {
			this.toPlace = toPlace;
		}
		public Integer getToPlaceId() {
			return toPlaceId;
		}
		public void setToPlaceId(Integer toPlaceId) {
			this.toPlaceId = toPlaceId;
		}
		public String getFromDate() {
			return fromDate;
		}
		public void setFromDate(String fromDate) {
			this.fromDate = fromDate;
		}
		public String getToDate() {
			return toDate;
		}
		public void setToDate(String toDate) {
			this.toDate = toDate;
		}
		public Integer getRank() {
			return rank;
		}
		public void setRank(Integer rank) {
			this.rank = rank;
		}		
		public String getDecision() {
			return decision;
		}
		public void setDecision(String decision) {
			this.decision = decision;
		}
		public String getFinalApprovedDate() {
			return finalApprovedDate;
		}
		public void setFinalApprovedDate(String finalApprovedDate) {
			this.finalApprovedDate = finalApprovedDate;
		}
		public String getCancelDate() {
			return cancelDate;
		}
		public void setCancelDate(String cancelDate) {
			this.cancelDate = cancelDate;
		}
		public String getReasonOfTravel() {
			return reasonOfTravel;
		}
		public void setReasonOfTravel(String reasonOfTravel) {
			this.reasonOfTravel = reasonOfTravel;
		}
		public String getStructure() {
			return structure;
		}
		public void setStructure(String structure) {
			this.structure = structure;
		}
		public Integer getStructureId() {
			return structureId;
		}
		public void setStructureId(Integer structureId) {
			this.structureId = structureId;
		}
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
		}
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public String getAuthorizationDate() {
			return authorizationDate;
		}
		public void setAuthorizationDate(String authorizationDate) {
			this.authorizationDate = authorizationDate;
		}
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
		public Integer getNextUserId() {
			return nextUserId;
		}
		public void setNextUserId(Integer nextUserId) {
			this.nextUserId = nextUserId;
		}
		public String getNextUser() {
			return nextUser;
		}
		public void setNextUser(String nextUser) {
			this.nextUser = nextUser;
		}
		public String getNextStructure() {
			return nextStructure;
		}
		public void setNextStructure(String nextStructure) {
			this.nextStructure = nextStructure;
		}
		public List<OfficerDTO> getOfficers() {
			return officers;
		}
		public void setOfficers(List<OfficerDTO> officers) {
			this.officers = officers;
		}
		public List<TravelDTO> getTravels() {
			return travels;
		}
		public void setTravels(List<TravelDTO> travels) {
			this.travels = travels;
		}
		public List<VehicleDTO> getVehicles() {
			return vehicles;
		}
		public void setVehicles(List<VehicleDTO> vehicles) {
			this.vehicles = vehicles;
		}
		public String getServiceObjectives() {
			return serviceObjectives;
		}
		public void setServiceObjectives(String serviceObjectives) {
			this.serviceObjectives = serviceObjectives;
		}
		public String getServiceRaporting() {
			return serviceRaporting;
		}
		public void setServiceRaporting(String serviceRaporting) {
			this.serviceRaporting = serviceRaporting;
		}
	    
	    
	    
	    
	

}
