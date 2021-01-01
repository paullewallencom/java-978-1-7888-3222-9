package com.javabullets.java9;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;

import com.javabullets.java9.beans.CreditCardBean;
import com.javabullets.java9.beans.EventBean;
import com.javabullets.java9.entity.Entrant;
import com.javabullets.java9.entity.Sex;

@Named
@RequestScoped
public class EnterEventController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private EventBean eventBean;

    @Inject
    private CreditCardBean creditCardBean;
    
    @PostConstruct
    public void initialize() {
        eventBean.setEntrant(new Entrant());
    }
    
    // Navigation
    public String index() {
        eventBean.reset();
        return "index.xhtml?faces-redirect=true";
    }

    public String create() {
        eventBean.getEvent().getEntrantList().add(eventBean.getEntrant());
        return "viewEntrant.xhtml?faces-redirect=true";
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
