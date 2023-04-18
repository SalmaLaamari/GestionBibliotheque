package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventDao extends JpaRepository<Event,Long> {
    Event findByReference(String reference);
    Event findByDescription(String description);
    List<Event> findByDateEvent(LocalDateTime date);
    Event deleteByReference(String reference);
}
