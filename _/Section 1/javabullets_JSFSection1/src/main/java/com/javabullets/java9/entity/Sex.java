package com.javabullets.java9.entity;

import java.io.Serializable;

public enum Sex implements Serializable {

	MALE("Male"), FEMALE("Female");

	private String label;

	private Sex(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}