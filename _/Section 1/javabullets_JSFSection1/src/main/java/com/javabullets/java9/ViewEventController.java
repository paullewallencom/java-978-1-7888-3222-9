package com.javabullets.java9;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.javabullets.java9.beans.EventBean;

@Named
@RequestScoped
public class ViewEventController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EventBean eventBean;

    // Navigation
    public String index() {
        return "index.xhtml?faces-redirect=true";
    }

    public String enter() {
        return "enterEvent.xhtml?faces-redirect=true";
    }

    public EventBean getEventBean() {
        return eventBean;
    }

    public void setEventBean(EventBean eventBean) {
        this.eventBean = eventBean;
    }

}
