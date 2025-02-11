package com.example.eventmanagementsystem.service;

import com.example.eventmanagementsystem.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    List<User> getUsersByEvent(Long eventId);
}