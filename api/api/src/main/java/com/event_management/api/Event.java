package com.event_management.api;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long event_id;

    @Column(nullable = false)
    private String eventname;


    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventdate;

    private String location;

    public Long getEvent_id() {
        return event_id;
    }
    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }
    public String getEventname() {
        return eventname;
    }
    public void setEventname(String eventname) {
        this.eventname = eventname;
    }
    public Date getEventdate() {
        return eventdate;
    }
    public void setEventdate(Date eventdate) {
        this.eventdate = eventdate;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
