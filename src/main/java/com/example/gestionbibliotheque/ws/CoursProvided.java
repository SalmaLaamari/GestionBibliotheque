package com.example.gestionbibliotheque.ws;

import com.example.gestionbibliotheque.bean.Cours;
import com.example.gestionbibliotheque.service.CoursService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("GestionBiblio/Cours")
public class CoursProvided {
    @Autowired
    private CoursService coursService;
   @GetMapping("/reference/{reference}")
    public Cours findByReference(@PathVariable String reference) {
        return coursService.findByReference(reference);
    }
    @GetMapping("/lien/{lien}")
    public Cours findByLien(@PathVariable String lien) {
        return coursService.findByLien(lien);
    }

    @GetMapping("/source/{source}")
    public List<Cours> findBySource(@PathVariable String source) {
        return coursService.findBySource(source);
    }

    @GetMapping("/description/{description}")
    public Cours findByDescription(@PathVariable String description) {
        return coursService.findByDescription(description);
    }

    @Transactional
    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return coursService.deleteByReference(reference);
    }
   @GetMapping("/")
    public List<Cours> findAll() {
        return coursService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Cours cours) {
        return coursService.save(cours);
    }
}
