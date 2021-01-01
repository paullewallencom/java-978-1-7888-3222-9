package com.javabullets.javaee8.payment;

import java.io.Serializable;

public class CreditCardDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String cardType;
	private String cardNumber;
	private String month;
	private String year;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

}