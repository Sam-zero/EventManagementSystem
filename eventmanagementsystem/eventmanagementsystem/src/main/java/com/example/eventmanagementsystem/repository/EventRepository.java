package com.example.eventmanagementsystem.repository;

import com.example.eventmanagementsystem.model.Event;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @EntityGraph(attributePaths = {"manager", "participants"}) // Fetch both manager and participants
    Optional<Event> findById(Long id);

    @EntityGraph(attributePaths = {"manager"}) // Fetch manager
    List<Event> findAll();

    List<Event> findByEventNameContainingIgnoreCase(String keyword);
    List<Event> findByLocationContainingIgnoreCase(String location);
    List<Event> findByEventDate(Date eventDate);
    List<Event> findByEventDateBetween(Date startDate, Date endDate);

    @Query("SELECT e FROM Event e WHERE " +
            "LOWER(e.eventName) LIKE LOWER(CONCAT('%', :keyword, '%')) AND " +
            "e.eventDate BETWEEN :startDate AND :endDate")
    List<Event> searchEvents(
            @Param("keyword") String keyword,
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate
    );
}
