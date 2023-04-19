package com.example.gestionbibliotheque.ws;

import com.example.gestionbibliotheque.bean.Penalite;
import com.example.gestionbibliotheque.service.PenaliteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("GestionBiblio/Penalite")
public class PenaliteProvided {
    @Autowired
    private PenaliteService penaliteService;
    @GetMapping("/Reference/{reference}")
    public Penalite findByReference(@PathVariable String reference) {
        return penaliteService.findByReference(reference);
    }
    @GetMapping("/DatePenalite/{date}")
    public List<Penalite> findByDatePenalite(@PathVariable LocalDateTime date) {
        return penaliteService.findByDatePenalite(date);
    }
    @DeleteMapping("/Reference/{reference}")
    @Transactional
    public int deleteByReference(@PathVariable String reference) {
        return penaliteService.deleteByReference(reference);
    }
    @GetMapping("/UtilisateurReference/{reference}")
    public Penalite findByUtilisateurReference(@PathVariable String reference) {
        return penaliteService.findByUtilisateurReference(reference);
    }
    @DeleteMapping("/UtilisateurReference/{reference}")
    @Transactional
    public int deleteByUtilisateurReference(@PathVariable String reference) {
        return penaliteService.deleteByUtilisateurReference(reference);
    }
    @GetMapping("/")
    public List<Penalite> findAll() {
        return penaliteService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Penalite penalite) {
        return penaliteService.save(penalite);
    }
    }
