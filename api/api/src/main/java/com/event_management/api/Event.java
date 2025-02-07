package com.event_management.api;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String eventname;


    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventdate;

    private String location;

    public Long getID() {
        return id;
    }
    public void setID(Long id) {
        this.id = id;
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
