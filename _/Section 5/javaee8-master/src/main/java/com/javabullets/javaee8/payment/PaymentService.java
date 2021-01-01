package com.javabullets.javaee8.payment;

public interface PaymentService {
	public default String processPayments(CreditCardDTO creditCardDTO) {
		return "Payment Successful";
	}
}
