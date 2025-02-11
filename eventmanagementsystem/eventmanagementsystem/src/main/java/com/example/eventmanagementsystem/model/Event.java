package com.example.eventmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventid")
    @JsonFormat
    private Long eventId;

    @NotBlank(message = "Event name cannot be empty")
    @Column(name = "eventname")
    @Size(max = 255, message = "Event name is too long")
    @JsonFormat
    private String eventName;

    @NotNull(message = "Event date cannot be empty")
    @Column(name = "eventdate")
    @JsonFormat
    private Date eventDate;

    @Size(max = 255, message = "Location is too long")
    @Column(name = "location")
    @JsonFormat
    private String location;

    @ManyToOne
    @JoinColumn(name = "ManagerID")
    private User manager;

    @ManyToMany(mappedBy = "events")
    @JsonIgnore
    private List<User> participants;
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public List<User> getParticipants() {
        return participants;
    }
}
