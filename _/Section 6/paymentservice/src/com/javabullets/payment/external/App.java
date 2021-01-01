package com.javabullets.payment.external;

import com.javabullets.payment.internal.SuccessPaymentServiceImpl;

public class App {
	public static void main(String[] args) {
		CreditCardDTO creditCardDTO = new CreditCardDTO();
		creditCardDTO.setCardType("Visa");
		creditCardDTO.setCardNumber("1234567887654321");
		creditCardDTO.setMonth("03");
		creditCardDTO.setYear("2018");
		
		PaymentServiceFacade paymentService = new PaymentServiceFacade();
		System.out.println(paymentService.processPayments(creditCardDTO));
		
		SuccessPaymentServiceImpl successPaymentService = new SuccessPaymentServiceImpl();
		System.out.println(successPaymentService.processPayments(creditCardDTO));
	}
}
