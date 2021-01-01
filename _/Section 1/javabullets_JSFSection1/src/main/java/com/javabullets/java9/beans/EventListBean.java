package com.javabullets.java9.beans;

import com.javabullets.java9.entity.Entrant;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;

import com.javabullets.java9.entity.Event;
import com.javabullets.java9.entity.Sex;
import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@Named
@ApplicationScoped
public class EventListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Event> eventList;

    @PostConstruct
    public void init() {
        Entrant entrant1 = new Entrant(1L, "Danice", "Sterzaker", 18, Sex.FEMALE);
        Entrant entrant2 = new Entrant(2L, "Kaylyn", "Howlett", 40, Sex.FEMALE);
        Entrant entrant3 = new Entrant(3L, "Peggie", "Oldam", 22, Sex.FEMALE);
        Entrant entrant4 = new Entrant(4L, "Verla", "Prosser", 35, Sex.FEMALE);
        Entrant entrant5 = new Entrant(5L, "Desiree", "Kyte", 56, Sex.FEMALE);
        Entrant entrant6 = new Entrant(6L, "Andre", "Dowthwaite", 67, Sex.MALE);
        Entrant entrant7 = new Entrant(7L, "Babs", "Scholcroft", 19, Sex.FEMALE);
        Entrant entrant8 = new Entrant(8L, "Brucie", "Pointer", 24, Sex.MALE);
        Entrant entrant9 = new Entrant(9L, "Randi", "Cutcliffe", 26, Sex.FEMALE);
        Entrant entrant10 = new Entrant(10L, "Bondon", "Landsman", 78, Sex.MALE);
        Entrant entrant11 = new Entrant(11L, "Ivonne", "Carlet", 45, Sex.FEMALE);
        Entrant entrant12 = new Entrant(12L, "Huntlee", "Howison", 48, Sex.MALE);
        Entrant entrant13 = new Entrant(13L, "Auguste", "Deerness", 51, Sex.FEMALE);
        Entrant entrant14 = new Entrant(14L, "Patrice", "Job", 23, Sex.MALE);
        Entrant entrant15 = new Entrant(15L, "Bryce", "Cregan", 24, Sex.MALE);
        Entrant entrant16 = new Entrant(16L, "Kipp", "Toghill", 19, Sex.FEMALE);
        Entrant entrant17 = new Entrant(17L, "Cherish", "Chippindale", 64, Sex.FEMALE);
        Entrant entrant18 = new Entrant(18L, "Dewain", "Mirfield", 90, Sex.MALE);
        Entrant entrant19 = new Entrant(19L, "Filmer", "Fallon", 21, Sex.MALE);
        Entrant entrant20 = new Entrant(20L, "Viole", "Pettyfer", 29, Sex.FEMALE);

        Event edinburghMarathonEvent = new Event(1L, "Edinburgh Marathon", LocalDateTime.parse("2018-05-04T10:11:30"), "Edinburgh", "UK");
        edinburghMarathonEvent.getEntrantList().add(entrant1);
        edinburghMarathonEvent.getEntrantList().add(entrant2);
        edinburghMarathonEvent.getEntrantList().add(entrant3);
        edinburghMarathonEvent.getEntrantList().add(entrant4);

        Event londonMarathonEvent = new Event(2L, "London Marathon", LocalDateTime.parse("2018-04-04T10:11:30"), "London", "UK");
        londonMarathonEvent.getEntrantList().add(entrant5);
        londonMarathonEvent.getEntrantList().add(entrant6);
        londonMarathonEvent.getEntrantList().add(entrant7);
        londonMarathonEvent.getEntrantList().add(entrant8);

        Event tokyoMarathonEvent = new Event(3L, "Tokyo Marathon", LocalDateTime.parse("2018-02-25T10:11:30"), "Tokyo", "Japan");
        tokyoMarathonEvent.getEntrantList().add(entrant9);
        tokyoMarathonEvent.getEntrantList().add(entrant10);
        tokyoMarathonEvent.getEntrantList().add(entrant11);
        tokyoMarathonEvent.getEntrantList().add(entrant12);

        Event berlinMarathonEvent = new Event(4L, "Berlin Marathon", LocalDateTime.parse("2018-09-16T10:11:30"), "Berlin", "Germany");
        berlinMarathonEvent.getEntrantList().add(entrant13);
        berlinMarathonEvent.getEntrantList().add(entrant14);
        berlinMarathonEvent.getEntrantList().add(entrant15);
        berlinMarathonEvent.getEntrantList().add(entrant16);

        Event newYorkMarathonEvent = new Event(5L, "New York Marathon", LocalDateTime.parse("2018-11-04T10:11:30"), "New York", "USA");
        newYorkMarathonEvent.getEntrantList().add(entrant17);
        newYorkMarathonEvent.getEntrantList().add(entrant18);
        newYorkMarathonEvent.getEntrantList().add(entrant19);
        newYorkMarathonEvent.getEntrantList().add(entrant20);

        eventList = List.of(edinburghMarathonEvent, londonMarathonEvent, tokyoMarathonEvent, berlinMarathonEvent, newYorkMarathonEvent);

    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

}