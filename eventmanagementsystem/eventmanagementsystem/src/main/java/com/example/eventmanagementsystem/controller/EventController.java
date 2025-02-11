package com.example.eventmanagementsystem.controller;

import com.example.eventmanagementsystem.exception.EntityNotFoundException;
import com.example.eventmanagementsystem.exception.InvalidInputException;
import com.example.eventmanagementsystem.model.Event;
import com.example.eventmanagementsystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        return eventService.getEventById(id)
                .map(event -> ResponseEntity.ok(event))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@Valid @RequestBody Event event) {
        try {
            Event createdEvent = eventService.createEvent(event);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
        } catch (InvalidInputException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @Valid @RequestBody Event event) {
        try {
            Event updatedEvent = eventService.updateEvent(id, event);
            return ResponseEntity.ok(updatedEvent);
        } catch (InvalidInputException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        try {
            eventService.deleteEvent(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/participants")
    public ResponseEntity<Event> addParticipants(
            @PathVariable Long id, @RequestBody List<Long> participantIds) {
        Event updatedEvent = eventService.addParticipants(id, participantIds); // Implement this
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}/participants")
    public ResponseEntity<Event> removeParticipants(
            @PathVariable Long id, @RequestBody List<Long> participantIds) {
        Event updatedEvent = eventService.removeParticipants(id, participantIds); // Implement this
        return ResponseEntity.ok(updatedEvent);
    }

    @GetMapping("/search")
    public List<Event> searchEvents(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
    ) {
        return eventService.searchEvents(keyword, startDate, endDate);
    }


    @GetMapping("/name")
    public List<Event> findByEventName(@RequestParam("keyword") String keyword) {
        return eventService.findByEventName(keyword);
    }

    @GetMapping("/location")
    public List<Event> findByLocation(@RequestParam("location") String location) {
        return eventService.findByLocation(location);
    }

    @GetMapping("/date")
    public List<Event> findByEventDate(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date eventDate) {
        return eventService.findByEventDate(eventDate);
    }

    @GetMapping("/date-between")
    public List<Event> findByEventDateBetween(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
    ) {
        return eventService.findByEventDateBetween(startDate, endDate);
    }
}