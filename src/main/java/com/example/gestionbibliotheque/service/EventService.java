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
    @Autowired
    private CategorieEventService categorieEventService;

    public Event findByReference(String reference) {
        return eventDao.findByReference(reference);
    }

    public Event findByDescription(String description) {
        return eventDao.findByDescription(description);
    }

    public List<Event> findByDateEvent(LocalDateTime date) {
        return eventDao.findByDateEvent(date);
    }

    public List<Event> findByCategorieEventNom(String nom) {
        return eventDao.findByCategorieEventNom(nom);
    }

    public Event findByTitre(String titre) {
        return eventDao.findByTitre(titre);
    }

    @Transactional
    public int deleteByTitre(String titre) {
        return eventDao.deleteByTitre(titre);
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
        } else if (event.getTitre()==null) {
            return -3;
        }else {
            event.setCategorieEvent(event.getCategorieEvent());
            categorieEventService.save(event.getCategorieEvent());
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
            if (event.getCategorieEvent() != null) {
                event1.setCategorieEvent(event.getCategorieEvent());
            }
            if (event.getImageEvent() != null) {
                event1.setImageEvent(event.getImageEvent());
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
