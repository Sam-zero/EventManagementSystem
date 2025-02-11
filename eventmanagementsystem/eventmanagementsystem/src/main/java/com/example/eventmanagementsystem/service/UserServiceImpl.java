package com.example.eventmanagementsystem.service;

import com.example.eventmanagementsystem.exception.EntityNotFoundException;
import com.example.eventmanagementsystem.exception.InvalidInputException;
import com.example.eventmanagementsystem.model.Event;
import com.example.eventmanagementsystem.model.User;
import com.example.eventmanagementsystem.repository.EventRepository;
import com.example.eventmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private EventRepository eventRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new InvalidInputException("Error creating user: " + e.getMessage());
        }
    }

    @Override
    public User updateUser(Long id, User user) {
        try {
            user.setUserId(id);
            return userRepository.save(user);
        } catch (Exception e) {
            throw new InvalidInputException("Error updating user: " + e.getMessage());
        }
    }

    @Override
    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new EntityNotFoundException("User with id " + id + " not found");
        }
    }

    @Override
    public List<User> getUsersByEvent(Long eventId) {
        Optional<Event> event = eventRepository.findById(eventId);
        if (!event.isPresent()) {
            return Collections.emptyList();
        }

        return event.get().getParticipants();
    }
}
