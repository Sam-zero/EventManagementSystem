package com.event_management.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    private final ParticipantRepository participantRepository;
    private final EventRepository eventRepository;

    public ParticipantController(ParticipantRepository participantRepository, EventRepository eventRepository) {
        this.participantRepository = participantRepository;
        this.eventRepository = eventRepository;
    }

    @PostMapping
    public ResponseEntity<Participant> createParticipant(@RequestBody Participant participant,
                                                         @RequestParam Long eventId) {
        return eventRepository.findById(eventId)
                .map(event -> {
                    participant.setEvent(event);
                    return ResponseEntity.ok(participantRepository.save(participant));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/event/{eventId}")
    public List<Participant> getParticipantsByEvent(@PathVariable Long eventId) {
        return participantRepository.findByEventId(eventId);
    }
}
