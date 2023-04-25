package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.Event;
import com.example.gestionbibliotheque.dao.EventDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventDao eventDao;

    public Event findByReference(String reference) {
        return eventDao.findByReference(reference);
    }

    public Event findByDescription(String description) {
        return eventDao.findByDescription(description);
    }

    public List<Event> findByDateEvent(LocalDateTime date) {
        return eventDao.findByDateEvent(date);
    }
    @Transactional
    public int deleteByReference(String reference) {
        return eventDao.deleteByReference(reference);
    }
    public int save(Event event){
         if (event.getDescription()==null) {
            return -1;
        } else if (event.getImageEvent()==null) {
            return -2;
        }else {
            eventDao.save(event);
            event.setReference("Event-"+event.getId());
            eventDao.save(event);
            return 1;
        }

    }
    public List<Event> findAll() {
        return eventDao.findAll();
    }
}
