package com.example.gestionbibliotheque.ws;

import com.example.gestionbibliotheque.bean.Paiement;
import com.example.gestionbibliotheque.service.PaiementService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("GestionBiblio/Paiement")
public class PaiementProvided {
    @Autowired
    private PaiementService paiementService;
    @GetMapping("/Reference/{reference}")
    public Paiement findByReference(@PathVariable String reference) {
        return paiementService.findByReference(reference);
    }
    @GetMapping("/DatePaiement/{date}")
    public List<Paiement> findByDatePaiement(@PathVariable LocalDateTime date) {
        return paiementService.findByDatePaiement(date);
    }
    @DeleteMapping("/Reference/{reference}")
    @Transactional
    public int deleteByReference(@PathVariable String reference) {
        return paiementService.deleteByReference(reference);
    }
    @GetMapping("/")
    public List<Paiement> findAll() {
        return paiementService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Paiement paiement) {
        return paiementService.save(paiement);
    }

    @PutMapping("/")
    public int update(@RequestBody Paiement paiement) {
        return paiementService.update(paiement);
    }
}
