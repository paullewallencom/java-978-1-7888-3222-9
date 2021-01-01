package com.javabullets.javaee8.payment;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("payment")
public class PaymentRESTService {

	@Inject
	private PaymentService paymentService;

	@GET
	@Path("{cardType}/{cardNumber}/{month}/{year}")
	@Produces(MediaType.TEXT_PLAIN)
	public String processPaymentGet(
			@PathParam("cardType") String cardType, 
			@PathParam("cardNumber") String cardNumber,
			@PathParam("month") String month, 
			@PathParam("year") String year) {
		CreditCardDTO creditCardDTO = new CreditCardDTO();
		creditCardDTO.setCardType(cardType);
		creditCardDTO.setCardNumber(cardNumber);
		creditCardDTO.setMonth(month);
		creditCardDTO.setYear(year);
		// http://localhost:9080/javaee8/api/payment/Visa/1111111111111111/10/2018
		return paymentService.processPayments(creditCardDTO);
	}

    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String processPaymentPost(CreditCardDTO creditCardDTO) {
    	return paymentService.processPayments(creditCardDTO);
    }
}