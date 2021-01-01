package com.javabullets.java9;

import java.io.Serializable;
import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class SimpleController implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDate localDate;

    @PostConstruct
    public void postConstruct() {
    	localDate = LocalDate.now();
    }

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
}
