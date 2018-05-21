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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lorela.shehu
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "UserIdSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "UserIdSeq", sequenceName = "USER_ID_SEQ", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "SECRET")
    private String secret;
    @Column(name = "STATUS")
    private int status;
    @Column(name = "FINAL_APPROVAL")
    private Integer finalApproval;
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "UPDATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @ManyToMany
    @JoinTable(name = "USER_ROLE",
	    joinColumns = @JoinColumn(name = "USER_ID"),
	    inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
    )
    private List<Role> roles;
    @JoinColumn(name = "OFFICER_ID", referencedColumnName = "ID")
    @ManyToOne
    private Officer officer;
    @JoinColumn(name = "UPDATE_USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private User updateUser;
    @JoinColumn(name = "CREATE_USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private User createUser;

    public User() {
    }

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Officer getOfficer() {
		return officer;
	}

	public void setOfficer(Officer officer) {
		this.officer = officer;
	}

	public User getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(User updateUser) {
		this.updateUser = updateUser;
	}

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	public Integer getFinalApproval() {
		return finalApproval;
	}

	public void setFinalApproval(Integer finalApproval) {
		this.finalApproval = finalApproval;
	}

    
    
}
