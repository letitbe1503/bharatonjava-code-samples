package com.bharatonjava.school.domain;

public class Enumeration {

	private int enumId;
	private String enumGroup;
	private String enumValue;
	
	public Enumeration() {
	}

	public int getEnumId() {
		return enumId;
	}

	public void setEnumId(int enumId) {
		this.enumId = enumId;
	}

	public String getEnumGroup() {
		return enumGroup;
	}

	public void setEnumGroup(String enumGroup) {
		this.enumGroup = enumGroup;
	}

	public String getEnumValue() {
		return enumValue;
	}

	public void setEnumValue(String enumValue) {
		this.enumValue = enumValue;
	}

	@Override
	public String toString() {
		return "Enumeration [enumId=" + enumId + ", enumGroup=" + enumGroup
				+ ", enumValue=" + enumValue + "]";
	}
	
}
