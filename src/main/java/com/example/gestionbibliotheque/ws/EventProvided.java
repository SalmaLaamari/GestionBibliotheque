package com.example.gestionbibliotheque.ws;

import com.example.gestionbibliotheque.bean.Event;
import com.example.gestionbibliotheque.service.EventService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("GestionBiblio/Event")
public class EventProvided {
    @Autowired
    private EventService eventService;
    @GetMapping("/reference/{reference}")
    public Event findByReference(@PathVariable String reference) {
        return eventService.findByReference(reference);
    }
    @GetMapping("/description/{description}")
    public Event findByDescription(@PathVariable String description) {
        return eventService.findByDescription(description);
    }
    @GetMapping("/date/{date}")
    public List<Event> findByDateEvent(@PathVariable LocalDateTime date) {
        return eventService.findByDateEvent(date);
    }
    @GetMapping("/nom/{nom}")
    public List<Event> findByCategorieEventNom(@PathVariable String nom) {
        return eventService.findByCategorieEventNom(nom);
    }

    @GetMapping("/titre/{titre}")
    public Event findByTitre(@PathVariable String titre) {
        return eventService.findByTitre(titre);
    }

    @Transactional
    @DeleteMapping("/titre/{titre}")
    public int deleteByTitre(@PathVariable String titre) {
        return eventService.deleteByTitre(titre);
    }

    @Transactional
    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return eventService.deleteByReference(reference);
    }
    @PostMapping("/")
    public int save(@RequestBody Event event) {
        return eventService.save(event);
    }
    @GetMapping("/")
    public List<Event> findAll() {
        return eventService.findAll();
    }

    @PutMapping("/")
    public int update(@RequestBody Event event) {
        return eventService.update(event);
    }
}
