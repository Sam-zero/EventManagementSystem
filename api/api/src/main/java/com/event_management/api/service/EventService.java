package com.event_management.api.service;

import com.event_management.api.model.Event;
import java.util.List;
import java.util.Optional;

public interface EventService {
    Event createEvent(Event event) throws Exception;
    List<Event> getAllEvents() throws Exception;
    Optional<Event> getEventById(Long id) throws Exception;
    Event updateEvent(Long id, Event event) throws Exception;
    void deleteEvent(Long id) throws Exception;
}
