package com.javabullets.payment.internal;

import com.javabullets.payment.external.CreditCardDTO;

public interface PaymentService {
	public String processPayments(CreditCardDTO creditCardDTO);
}
