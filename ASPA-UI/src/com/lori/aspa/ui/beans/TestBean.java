package com.lori.aspa.ui.beans;

import java.io.Serializable;

import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;



@Named
@ViewScoped
public class TestBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	String input;

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	
	
	
	
	
}
