package com.javabullets.java9;

import java.io.Serializable;
import java.time.LocalDate;

import javax.inject.Inject;
import javax.inject.Named;

import com.javabullets.java9.beans.EventBean;
import com.javabullets.java9.beans.EventListBean;
import com.javabullets.java9.entity.Event;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

@Named
@RequestScoped
public class MainController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Event selectedEvent;
    private LocalDate localDate;

    @Inject
    private EventBean eventBean;

    @Inject
    private EventListBean eventListBean;
    
    @PostConstruct
    public void postConstruct() {
    	localDate = LocalDate.now();

        eventBean.reset();
    }

    // Page Transitions
    public String viewEvent() {
        eventBean.setEvent(getSelectedEvent());
        return "viewEvent.xhtml?faces-redirect=true";
    }

    public String enterEvent() {
        eventBean.setEvent(getSelectedEvent());
        return "enterEvent.xhtml?faces-redirect=true";
    }

    // Getters/Setters
    public EventBean getEventBean() {
        return eventBean;
    }

    public void setEventBean(EventBean eventBean) {
        this.eventBean = eventBean;
    }

    public Event getSelectedEvent() {
        return selectedEvent;
    }

    public void setSelectedEvent(Event selectedEvent) {
        this.selectedEvent = selectedEvent;
    }

    public EventListBean getEventListBean() {
        return eventListBean;
    }

    public void setEventListBean(EventListBean eventListBean) {
        this.eventListBean = eventListBean;
    }

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

}
