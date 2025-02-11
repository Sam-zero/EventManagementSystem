package com.example.eventmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import com.example.eventmanagementsystem.model.Event;
import jakarta.validation.constraints.Email;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    @JsonFormat
    private Long userId;

    @NotBlank(message = "Username cannot be empty")
    @Column(name = "username")
    @Size(max = 255, message = "User name is too long")
    @JsonFormat
    private String userName;

    @Email(message = "Invalid email format")
    @Size(max = 255, message = "Email is too long")
    @Column(name = "useremail")
    @JsonFormat
    private String userEmail;

    @Column(name = "userphone")
    @Size(max = 20, message = "Phone number is too long")
    @JsonFormat
    private String userPhone;

    @Column(name = "iseventmanager")
    @JsonFormat
    private boolean isEventManager;

    @ManyToMany
    @JoinTable(
            name = "event_participants",
            joinColumns = @JoinColumn(name = "UserID"),
            inverseJoinColumns = @JoinColumn(name = "EventID")
    )
    @JsonIgnore
    private List<Event> events;
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
