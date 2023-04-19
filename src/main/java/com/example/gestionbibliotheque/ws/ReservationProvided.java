package com.example.gestionbibliotheque.ws;

import com.example.gestionbibliotheque.bean.Reservation;
import com.example.gestionbibliotheque.service.ReservationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("GestionBiblio/Reservation")
public class ReservationProvided {
    @Autowired
    private ReservationService reservationService;
    @GetMapping("/Reference/{reference}")
    public Reservation findByReference(@PathVariable String reference) {
        return reservationService.findByReference(reference);
    }
    @GetMapping("/DateReservation/{date}")
    public List<Reservation> findByDateReservation(@PathVariable LocalDateTime date) {
        return reservationService.findByDateReservation(date);
    }
    @GetMapping("/DateRendement/{date}")
    public List<Reservation> findByDateRendement(@PathVariable LocalDateTime date) {
        return reservationService.findByDateRendement(date);
    }
    @GetMapping("/LivreReference/{reference}")
    public Reservation findByLivreReference(@PathVariable String reference) {
        return reservationService.findByLivreReference(reference);
    }
    @GetMapping("/UtilisateurReference/{reference}")
    public Reservation findByUtilisateurReference(@PathVariable String reference) {
        return reservationService.findByUtilisateurReference(reference);
    }
    @DeleteMapping("/Reference/{reference}")
    @Transactional
    public int deleteByReference(@PathVariable String reference) {
        return reservationService.deleteByReference(reference);
    }
    @DeleteMapping("UtilisateurReference/{reference}")
    @Transactional
    public int deleteByUtilisateurReference(@PathVariable String reference) {
        return reservationService.deleteByUtilisateurReference(reference);
    }
    @DeleteMapping("/LivreReference/{reference}")
    @Transactional
    public int deleteByLivreReference(@PathVariable String reference) {
        return reservationService.deleteByLivreReference(reference);
    }
    @GetMapping("/")
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }
}
