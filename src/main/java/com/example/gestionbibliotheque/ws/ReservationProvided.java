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

    @GetMapping("/LivreReference/{reference}")
    public Reservation findByLivreReference(@PathVariable String reference) {
        return reservationService.findByLivreReference(reference);
    }
    @GetMapping("/UtilisateurReference/{reference}")
    public Reservation findByUtilisateurReference(@PathVariable String reference) {
        return reservationService.findByUtilisateurReference(reference);
    }

    @GetMapping("/UtilisateurCin/{cin}")
    public Reservation findByUtilisateurCin(@PathVariable String cin) {
        return reservationService.findByUtilisateurCin(cin);
    }
    @GetMapping("/Cin/{cin}/Titre/{titre}")
    public Reservation findByUtilisateurCinAndLivreTitre(@PathVariable String cin,@PathVariable String titre) {
        return reservationService.findByUtilisateurCinAndLivreTitre(cin, titre);
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
    @Transactional
    public int save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @PutMapping("/")
    public int update(@RequestBody Reservation reservation) {
        return reservationService.update(reservation);
    }
}
