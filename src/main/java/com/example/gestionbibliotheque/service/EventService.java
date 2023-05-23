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

    public List<Event> findByCategorie(String categorie) {
        return eventDao.findByCategorie(categorie);
    }

    public Event findByTitre(String titre) {
        return eventDao.findByTitre(titre);
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
        }else {
            event.setImageEvent("assets/images/Event/" + event.getTitre() + ".jpg");
            eventDao.save(event);
            event.setReference("Event-"+event.getId());
            eventDao.save(event);
            return 1;
        }

    }

    public int update(Event event){
        Event event1 = findByReference(event.getReference());
        if (event1 != null){
            if (event.getTitre() != null) {
                event1.setTitre(event.getTitre());
            }
            if (event.getDescription() != null) {
                event1.setDescription(event.getDescription());
            }
            if (event.getDateEvent() != null) {
                event1.setDateEvent(event.getDateEvent());
            }
            if (event.getImageEvent() != null) {
                event1.setImageEvent(event.getImageEvent());
            }
            if (event.getCategorie() != null) {
                event1.setCategorie(event.getCategorie());
            }
            eventDao.save(event1);
            return 1;
        } else {
            eventDao.save(event);
            return 2;
        }
    }

    public List<Event> findAll() {
        return eventDao.findAll();
    }
}
