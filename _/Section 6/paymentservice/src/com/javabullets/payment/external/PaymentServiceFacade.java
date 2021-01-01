package com.javabullets.payment.external;

import com.javabullets.payment.internal.DefaultPaymentServiceImpl;

public class PaymentServiceFacade {

	public String processPayments(CreditCardDTO creditCardDTO) {
		return new DefaultPaymentServiceImpl().processPayments(creditCardDTO);
	}
}
