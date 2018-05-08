/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lori.aspa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lorela.shehu
 */
@Entity
@Table(name = "AUTHORIZATION")
public class Authorization implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @JoinColumn(name = "FROM_PLACE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Place fromPlace;
    @JoinColumn(name = "TO_PLACE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Place toPlace;
    @Column(name = "FROM_DATE")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Column(name = "TO_DATE")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @Column(name = "RANK")
    private int rank;
    @Column(name = "APPROVED")
    private String approved;
    @Column(name = "FINAL_APPROVED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finalApprovedDate;
    @Column(name = "CANCEL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cancelDate;
    @Column(name = "REASON_OF_TRAVEL")
    private String reasonOfTravel;
    @Column(name = "MARKET_FOR_CHANGE")
    private int marketForChange;
    @Column(name = "STATUS")
    private int status;
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "UPDATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @JoinColumn(name = "NEXT_USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private User nextUser;
    @JoinTable(name = "AUTHORIZATION_OFFICERS", joinColumns = {
        @JoinColumn(name = "AUTHORIZATION_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "OFFICER_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Officer> officers;
    @JoinTable(name = "AUTHORIZATION_VEHICLES", joinColumns = {
        @JoinColumn(name = "AUTHORIZATION_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "VEHICLE_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Vehicle> vehicles;
    @JoinColumn(name = "STRUCTURE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Structure structure;
    @JoinColumn(name = "UPDATE_USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private User updateUser;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private User user;
    @JoinColumn(name = "CREATE_USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private User createUser;

    public Authorization() {
    	
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Place getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(Place fromPlace) {
		this.fromPlace = fromPlace;
	}

	public Place getToPlace() {
		return toPlace;
	}

	public void setToPlace(Place toPlace) {
		this.toPlace = toPlace;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public Date getFinalApprovedDate() {
		return finalApprovedDate;
	}

	public void setFinalApprovedDate(Date finalApprovedDate) {
		this.finalApprovedDate = finalApprovedDate;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getReasonOfTravel() {
		return reasonOfTravel;
	}

	public void setReasonOfTravel(String reasonOfTravel) {
		this.reasonOfTravel = reasonOfTravel;
	}

	public int getMarketForChange() {
		return marketForChange;
	}

	public void setMarketForChange(int marketForChange) {
		this.marketForChange = marketForChange;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public List<Officer> getOfficers() {
		return officers;
	}

	public void setOfficers(List<Officer> officers) {
		this.officers = officers;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public Structure getStructure() {
		return structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}

	public User getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(User updateUser) {
		this.updateUser = updateUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User getNextUser() {
		return nextUser;
	}

	public void setNextUser(User nextUser) {
		this.nextUser = nextUser;
	}

	
    

}