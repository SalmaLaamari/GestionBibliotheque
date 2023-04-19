package com.example.gestionbibliotheque.ws;

import com.example.gestionbibliotheque.bean.FicheReservation;
import com.example.gestionbibliotheque.service.FicheReservationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("GestionBiblio/FicheReservation")
public class FicheReservationProvided {
    @Autowired
    private FicheReservationService ficheReservationService;
    @GetMapping("/reference/{reference}")
    public FicheReservation findByReference(@PathVariable String reference) {
        return ficheReservationService.findByReference(reference);
    }
    @GetMapping("/UtilisateurReference/{reference}")
    public FicheReservation findByUtilisateurReference(@PathVariable String reference) {
        return ficheReservationService.findByUtilisateurReference(reference);
    }

    @Transactional
    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return ficheReservationService.deleteByReference(reference);
    }
    @GetMapping("/")
    public List<FicheReservation> findAll() {
        return ficheReservationService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody FicheReservation ficheReservation) {
        return ficheReservationService.save(ficheReservation);
    }
}
