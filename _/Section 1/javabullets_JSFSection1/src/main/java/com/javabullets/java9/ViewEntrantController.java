package com.javabullets.java9;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.javabullets.java9.beans.CreditCardBean;
import com.javabullets.java9.beans.EventBean;

@Named
@RequestScoped
public class ViewEntrantController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EventBean eventBean;

    @Inject
    private CreditCardBean creditCardBean;

    // Navigation
    public String index() {
        eventBean.reset();
        return "index.xhtml?faces-redirect=true";
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