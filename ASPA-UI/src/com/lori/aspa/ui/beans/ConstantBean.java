package com.lori.aspa.ui.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.lori.aspa.ui.constants.IDecision;
import com.lori.aspa.ui.constants.IStatus;

@ManagedBean
@RequestScoped
public class ConstantBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	String DECISION_ACCEPT = IDecision.ACCEPT;
	String DECISION_DENY = IDecision.DENY;
	String DECISION_IN_PROCESS = IDecision.IN_PROCESS;
	String DECISION_RETURNED = IDecision.RETURNED;
	
	int ACTIVE = IStatus.ACTIVE;
	int NOT_ACTIVE = IStatus.NOT_ACTIVE;
	
	public String getDECISION_ACCEPT() {
		return DECISION_ACCEPT;
	}
	public void setDECISION_ACCEPT(String dECISION_ACCEPT) {
		DECISION_ACCEPT = dECISION_ACCEPT;
	}
	public String getDECISION_DENY() {
		return DECISION_DENY;
	}
	public void setDECISION_DENY(String dECISION_DENY) {
		DECISION_DENY = dECISION_DENY;
	}
	public String getDECISION_IN_PROCESS() {
		return DECISION_IN_PROCESS;
	}
	public void setDECISION_IN_PROCESS(String dECISION_IN_PROCESS) {
		DECISION_IN_PROCESS = dECISION_IN_PROCESS;
	}
	public String getDECISION_RETURNED() {
		return DECISION_RETURNED;
	}
	public void setDECISION_RETURNED(String dECISION_RETURNED) {
		DECISION_RETURNED = dECISION_RETURNED;
	}
	public int getACTIVE() {
		return ACTIVE;
	}
	public void setACTIVE(int aCTIVE) {
		ACTIVE = aCTIVE;
	}
	public int getNOT_ACTIVE() {
		return NOT_ACTIVE;
	}
	public void setNOT_ACTIVE(int nOT_ACTIVE) {
		NOT_ACTIVE = nOT_ACTIVE;
	}
	

	
	
	
	
	
}
