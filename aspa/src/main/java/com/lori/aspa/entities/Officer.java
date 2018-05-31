/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lori.aspa.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "OFFICER")
public class Officer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "POSITION")
    private String position;
    @Column(name = "FUNCTION")
    private String function;
    @Column(name = "GRADE")
    private String grade;
    @Column(name = "STATUS")
    private int status;
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "UPDATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @JoinColumn(name = "STRUCTURE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Structure structure;
    @JoinColumn(name = "UPDATE_USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private User updateUser;
    @JoinColumn(name = "CREATE_USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private User createUser;
    
    

	public Officer() {
    }

    
    public Officer(int id) {
    	this.id = id;
    }

    

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


	public User getCreateUser() {
		return createUser;
	}


	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}



    
}
