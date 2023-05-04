package com.example.gestionbibliotheque.ws;

import com.example.gestionbibliotheque.bean.CategorieEvent;
import com.example.gestionbibliotheque.service.CategorieEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("GestionBiblio/CategorieEvent")
public class CategorieEventProvided {
    @Autowired
    private CategorieEventService categorieEventService;

    @GetMapping("/reference/{reference}")
    public CategorieEvent findByReference(@PathVariable String reference) {
        return categorieEventService.findByReference(reference);
    }
    @GetMapping("/nom/{nom}")
    public CategorieEvent findByNom(@PathVariable String nom) {
        return categorieEventService.findByNom(nom);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return categorieEventService.deleteByReference(reference);
    }

    @DeleteMapping("/nom/{nom}")
    public int deleteByNom(@PathVariable String nom) {
        return categorieEventService.deleteByNom(nom);
    }

    @GetMapping("/")
    public List<CategorieEvent> findAll() {
        return categorieEventService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody CategorieEvent categorieEvent) {
        return categorieEventService.save(categorieEvent);
    }

    @PutMapping("/")
    public int update(@RequestBody CategorieEvent categorieEvent) {
        return categorieEventService.update(categorieEvent);
    }
}
