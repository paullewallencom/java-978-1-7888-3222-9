package com.javabullets.java9.services;

import com.javabullets.java9.dto.CreditCardDTO;

public interface PaymentService {
	public default String processPayments(CreditCardDTO creditCardDTO) {
		return getResult();
	}
	private static String getResult() {
		return "PaymentSuccessful";
	}
}
