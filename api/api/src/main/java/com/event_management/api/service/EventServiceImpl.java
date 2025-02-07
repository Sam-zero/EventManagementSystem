package com.event_management.api.service;

import com.event_management.api.model.Event;
import com.event_management.api.repository.EventRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event createEvent(Event event) throws Exception {
        try {
            return eventRepository.save(event);
        } catch (Exception e) {
            throw new Exception("Error creating event: " + e.getMessage());
        }
    }

    @Override
    public List<Event> getAllEvents() throws Exception {
        try {
            return eventRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error getting all events: " + e.getMessage());
        }
    }

    @Override
    public Optional<Event> getEventById(Long id) throws Exception {
        try {
            return eventRepository.findById(id);
        } catch (Exception e) {
            throw new Exception("Error getting event by id: " + e.getMessage());
        }
    }

    @Override
    public Event updateEvent(Long id, Event event) throws Exception {
        try {
            event.setId(id); // Устанавливаем ID для обновления
            return eventRepository.save(event);
        } catch (Exception e) {
            throw new Exception("Error updating event: " + e.getMessage());
        }
    }

    @Override
    public void deleteEvent(Long id) throws Exception {
        try {
            eventRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Error deleting event: " + e.getMessage());
        }
    }
}
