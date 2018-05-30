package com.lori.aspa.ui.models;

public class ValuePair {

	String key;
	Object value;
	
	public ValuePair() {}
	
	public ValuePair(String key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	
	
}
