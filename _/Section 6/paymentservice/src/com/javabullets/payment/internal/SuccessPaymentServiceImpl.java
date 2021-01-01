package com.javabullets.payment.internal;

import com.javabullets.payment.external.CreditCardDTO;
import com.javabullets.payment.internal.PaymentService;

public class SuccessPaymentServiceImpl implements PaymentService {
	@Override
	public String processPayments(CreditCardDTO creditCardDTO) {
		return "Payment Successful";
	}
}
