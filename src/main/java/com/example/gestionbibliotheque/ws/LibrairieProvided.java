package com.example.gestionbibliotheque.ws;

import com.example.gestionbibliotheque.bean.Librairie;
import com.example.gestionbibliotheque.service.LibrairieService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("GestionBiblio/Librairie")
public class LibrairieProvided {
    @Autowired
    private LibrairieService librairieService;
    @GetMapping("/LibrairieReference/{reference}")
    public Librairie findByReference(@PathVariable String reference) {
        return librairieService.findByReference(reference);
    }
    @GetMapping("/Nom/{nom}")
    public Librairie findByNom(@PathVariable String nom) {
        return librairieService.findByNom(nom);
    }
    @GetMapping("/Adresse/{adresse}")
    public Librairie findByAdresse(@PathVariable String adresse) {
        return librairieService.findByAdresse(adresse);
    }
    @GetMapping("/Email/{email}")
    public Librairie findByEmail(@PathVariable String email) {
        return librairieService.findByEmail(email);
    }
    @DeleteMapping("/reference/{reference}")
    @Transactional
    public int deleteByReference(@PathVariable String reference) {
        return librairieService.deleteByReference(reference);
    }
    @GetMapping("/")
    public List<Librairie> findAll() {
        return librairieService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Librairie librairie) {
        return librairieService.save(librairie);
    }
}
