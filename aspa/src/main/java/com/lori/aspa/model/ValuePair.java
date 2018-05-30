package com.lori.aspa.model;

import java.util.Date;

import com.lori.aspa.utils.DateUtil;

public class ValuePair {

	String key;
	Object value;
	
	public ValuePair() {}
	
	public ValuePair(Date key, long value) {
		super();
		this.key = DateUtil.formatDate(key);
		this.value = value;
	}
	
	public ValuePair(int key, Object value) {
		super();
		this.key = String.valueOf(key);
		this.value = value;
	}
	
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
