package com.event_management.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat
    @Column
    private String eventname;

    @JsonFormat
    @Column
    private Date eventdate;

    @JsonFormat
    @Column
    private String location;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}