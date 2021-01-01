package com.javabullets.javaee8.payment;

import java.util.Optional;
import java.util.Random;

import javax.inject.Named;

@Named
public class PaymentServiceImpl implements PaymentService {

	public static String getPaymentResult(CreditCardDTO creditCardDTO) {
		Optional<String> paymentResult = validateCardNumber(creditCardDTO.getCardNumber())
				.or(() -> checkFunds(creditCardDTO))
				.or(() -> Optional.of("Payment Successful"));
		return paymentResult.get();
	}

	private static Optional<String> checkFunds(CreditCardDTO creditCardDTO) {
		Random rand = new Random();
		if (rand.nextBoolean()) {
			return Optional.empty();
		} else {
			return Optional.of("No Funds");
		}
	}

	private static String removeNonNumericCharacters(String cardNumber) {
		return cardNumber.chars().takeWhile(p -> Character.isDigit(p))
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
	}

	private static Optional<String> validateCardNumber(String cardNumber) {
		Optional<String> cardNumberOptional = Optional.of(cardNumber);
		if (!cardNumberOptional.get().equals(removeNonNumericCharacters(cardNumberOptional.get()))) {
			return Optional.of("Card Number contains non-numeric characters");
		} else if ((cardNumber.length() < 13) || (cardNumber.length() > 19)) {
			return Optional.of("Card Number is wrong length");
		} else {
			return Optional.empty();
		}
	}

	@Override
	public String processPayments(CreditCardDTO creditCardDTO) {
		return getPaymentResult(creditCardDTO);
	}
}
