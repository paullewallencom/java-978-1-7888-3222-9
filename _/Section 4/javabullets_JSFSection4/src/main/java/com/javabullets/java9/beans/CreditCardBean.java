package com.javabullets.java9.beans;

import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.javabullets.java9.dto.CreditCardDTO;

import static java.util.Map.entry;

@Named
@RequestScoped
public class CreditCardBean {

	private String cardType;
	private String cardNumber;
	private String month;
	private String year;

	private Map<String, String> cardMap;
	private Map<String, String> monthsMap;
	private Map<String, String> yearMap;

	@PostConstruct
	public void initialize() {

		setCardMap(new TreeMap<> (Map.of("Visa", "Visa", "MasterCard", "MasterCard", "AMEX", "AMEX") ));

		setMonthsMap(new TreeMap<> (
				Map.ofEntries(
				entry("01", "January"),
				entry("02", "February"),
				entry("03", "March"),
				entry("04", "April"), 
				entry("05", "May"), 
				entry("06", "June"), 
				entry("07", "July"),
				entry("08", "August"), 
				entry("09", "September"),
                entry("10", "October"), 
                entry("11", "November"),
				entry("12", "December"))));

		setYearMap(
				new TreeMap<> (Map.of("2017", "2017", "2018", "2018", "2019", "2019", "2020", "2020", "2021", "2021")));
	}

	public CreditCardDTO getCreditCardDTO() {
		CreditCardDTO creditCardDTO = new CreditCardDTO();
		creditCardDTO.setCardNumber(cardNumber);
		creditCardDTO.setCardType(cardType);
		creditCardDTO.setMonth(month);
		creditCardDTO.setYear(year);
		return creditCardDTO;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Map<String, String> getMonthsMap() {
		return monthsMap;
	}

	public void setMonthsMap(Map<String, String> monthsMap) {
		this.monthsMap = monthsMap;
	}

	public Map<String, String> getYearMap() {
		return yearMap;
	}

	public void setYearMap(Map<String, String> yearMap) {
		this.yearMap = yearMap;
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

	public Map<String, String> getCardMap() {
		return cardMap;
	}

	public void setCardMap(Map<String, String> cardMap) {
		this.cardMap = cardMap;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

}