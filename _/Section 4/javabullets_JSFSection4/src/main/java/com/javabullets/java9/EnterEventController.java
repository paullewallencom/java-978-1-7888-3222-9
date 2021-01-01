package com.javabullets.java9;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import com.javabullets.java9.beans.CreditCardBean;
import com.javabullets.java9.beans.EventBean;
import com.javabullets.java9.dao.EntrantService;
import com.javabullets.java9.dao.EventService;
import com.javabullets.java9.dto.CreditCardDTO;
import com.javabullets.java9.entity.Entrant;
import com.javabullets.java9.entity.Event;
import com.javabullets.java9.entity.Sex;
import com.javabullets.java9.services.PaymentService;

@Named
@RequestScoped
public class EnterEventController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private EventBean eventBean;

    @Inject
    private CreditCardBean creditCardBean;
    
    @Inject
    @Named("defaultPayment")
    private PaymentService paymentService;
    
    @EJB
    private EntrantService entrantService;
    
    @EJB
    private EventService eventService;
    
    @PostConstruct
    public void initialize() {
        eventBean.setEntrant(new Entrant());
    }
    
    // Navigation
    public String index() {
        eventBean.reset();
        return "index.xhtml?faces-redirect=true";
    }

    public String create() throws Exception {
    	CreditCardDTO creditCardDTO = creditCardBean.getCreditCardDTO();
    	String result = paymentService.processPayments(creditCardDTO);
    	if ("PaymentSuccessful".equals(result)) {
    		Entrant entrant = eventBean.getEntrant();
    		eventService.addEntrant(eventBean.getEvent(), entrant);
            //eventBean.getEvent().getEntrantList().add(eventBean.getEntrant());
            return "viewEntrant.xhtml?faces-redirect=true";
    	} else {
    		return "entryFailure.xhtml?faces-redirect=true";
    	}
    }

    public Sex[] getSexes() {
        return Sex.values();
    }

    public EventBean getEventBean() {
        return eventBean;
    }

    public void setEventBean(EventBean eventBean) {
        this.eventBean = eventBean;
    }

    public CreditCardBean getCreditCardBean() {
        return creditCardBean;
    }

    public void setCreditCardBean(CreditCardBean creditCardBean) {
        this.creditCardBean = creditCardBean;
    }

}
