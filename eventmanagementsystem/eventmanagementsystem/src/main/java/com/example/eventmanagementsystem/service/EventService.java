package com.example.eventmanagementsystem.service;

import com.example.eventmanagementsystem.model.Event;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> getAllEvents();
    Optional<Event> getEventById(Long id);
    Event createEvent(Event event);
    Event updateEvent(Long id, Event event);
    void deleteEvent(Long id);
    Event addParticipants(Long eventId, List<Long> participantIds);
    Event removeParticipants(Long eventId, List<Long> participantIds);
    List<Event> searchEvents(String keyword, Date startDate, Date endDate);
    List<Event> findByEventName(String keyword);
    List<Event> findByLocation(String location);
    List<Event> findByEventDate(Date eventDate);
    List<Event> findByEventDateBetween(Date startDate, Date endDate);
}