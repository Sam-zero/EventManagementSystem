package com.example.eventmanagementsystem.service;

import com.example.eventmanagementsystem.exception.InvalidInputException;
import com.example.eventmanagementsystem.model.Event;
import com.example.eventmanagementsystem.model.User;
import com.example.eventmanagementsystem.repository.EventRepository;
import com.example.eventmanagementsystem.repository.UserRepository;
import com.example.eventmanagementsystem.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private UserRepository userRepository;
    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public Event createEvent(Event event) {
        try {
            return eventRepository.save(event);
        } catch (Exception e) {
            throw new InvalidInputException("Error creating event: " + e.getMessage());
        }
    }

    @Override
    public Event updateEvent(Long id, Event event) {
        try {
            event.setEventId(id);
            return eventRepository.save(event);
        } catch (Exception e) {
            throw new InvalidInputException("Error updating event: " + e.getMessage());
        }
    }

    @Override
    public void deleteEvent(Long id) {
        try {
            eventRepository.deleteById(id);
        } catch (Exception e) {
            throw new EntityNotFoundException("Event with id " + id + " not found");
        }
    }

    @Override
    public Event addParticipants(Long eventId, List<Long> participantIds) {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new EntityNotFoundException("Event not found"));
        List<User> participants = userRepository.findAllById(participantIds);
        event.getParticipants().addAll(participants); // Add participants to the event
        return eventRepository.save(event);
    }

    @Override
    public Event removeParticipants(Long eventId, List<Long> participantIds) {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new EntityNotFoundException("Event not found"));
        List<User> participantsToRemove = userRepository.findAllById(participantIds);
        event.getParticipants().removeAll(participantsToRemove); // Remove participants from the event
        return eventRepository.save(event);
    }

    @Override
    public List<Event> searchEvents(String keyword, Date startDate, Date endDate) {
        return eventRepository.searchEvents(keyword, startDate, endDate);
    }

    @Override
    public List<Event> findByEventName(String keyword) {
        return eventRepository.findByEventNameContainingIgnoreCase(keyword);
    }

    @Override
    public List<Event> findByLocation(String location) {
        return eventRepository.findByLocationContainingIgnoreCase(location);
    }

    @Override
    public List<Event> findByEventDate(Date eventDate) {
        return eventRepository.findByEventDate(eventDate);
    }

    @Override
    public List<Event> findByEventDateBetween(Date startDate, Date endDate) {
        return eventRepository.findByEventDateBetween(startDate, endDate);
    }
}
