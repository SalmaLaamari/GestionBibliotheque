package com.example.gestionbibliotheque.ws;

import com.example.gestionbibliotheque.bean.Facture;
import com.example.gestionbibliotheque.service.FactureService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("GestionBiblio/Facture")
public class FactureProvided {
    @Autowired
    private FactureService factureService;
    @GetMapping("/reference/{reference}")
    public Facture findByReference(@PathVariable String reference) {
        return factureService.findByReference(reference);
    }
    @GetMapping("/FournisseurLivreReference/{reference}")
    public List<Facture> findByFournisseurLivreReference(@PathVariable String reference) {
        return factureService.findByFournisseurLivreReference(reference);
    }
    @GetMapping("/total/{total}")
    public List<Facture> findByTotal(@PathVariable double total) {
        return factureService.findByTotal(total);
    }
    @GetMapping("/totalGreater/{total}")
    public List<Facture> findByTotalGreaterThan(@PathVariable double total) {
        return factureService.findByTotalGreaterThan(total);
    }
    @GetMapping("/totalLess/{total}")
    public List<Facture> findByTotalLessThan(@PathVariable double total) {
        return factureService.findByTotalLessThan(total);
    }
    @GetMapping("/PaiementReference/{reference}")
    public List<Facture> findByPaiementReference(@PathVariable String reference) {
        return factureService.findByPaiementReference(reference);
    }

    @Transactional
    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return factureService.deleteByReference(reference);
    }
   @GetMapping("/")
    public List<Facture> findAll() {
        return factureService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Facture facture) {
        return factureService.save(facture);
    }

    @PutMapping("/")
    public int update(@RequestBody Facture facture) {
        return factureService.update(facture);
    }
}
