package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.Livre;
import com.example.gestionbibliotheque.bean.Reservation;
import com.example.gestionbibliotheque.dao.ReservationDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationDao reservationDao;
    @Autowired
    private LivreService livreService;
    @Autowired
    private StockService stockService;

    public List<Reservation> findByDateReservation(LocalDateTime date) {
        return reservationDao.findByDateReservation(date);
    }

    public Reservation findByReference(String reference) {
        return reservationDao.findByReference(reference);
    }

    public Optional<Reservation> findByUtilisateurCinAndLivreTitre(String cin, String titre) {
        return reservationDao.findByUtilisateurCinAndLivreTitre(cin, titre);
    }

    public Reservation findByLivreReference(String reference) {
        return reservationDao.findByLivreReference(reference);
    }

    public Reservation findByUtilisateurReference(String reference) {
        return reservationDao.findByUtilisateurReference(reference);
    }
    @Transactional
    public int deleteByReference(String reference) {
        return reservationDao.deleteByReference(reference);
    }
    @Transactional
    public int deleteByUtilisateurReference(String reference) {
        return reservationDao.deleteByUtilisateurReference(reference);
    }


    @Transactional
    public int deleteByLivreReference(String reference) {
        return reservationDao.deleteByLivreReference(reference);
    }


    public List<Reservation> findAll() {
        return reservationDao.findAll();
    }

    @Transactional
    public int save(Reservation reservation) {
        /* Vérifier si une réservation pour ce livre et cet utilisateur existe déjà
        Optional<Reservation> existingReservation = reservationDao.findByUtilisateurCinAndLivreTitre(
                reservation.getUtilisateur().getCin(),
                reservation.getLivre().getTitre());

        if (existingReservation.isPresent()) {
            // Une réservation existe déjà pour ce livre et cet utilisateur
            return -1;
        }
         */

        // Trouver le livre correspondant
        Optional<Livre> livre = livreService.findByTitre(reservation.getLivre().getTitre());
        if (!livre.isPresent()) {
            // Le livre n'a pas été trouvé
            return -2;
        }

        // Vérifier si une copie est disponible
        if (livre.get().getNbrEmpreintes() <= 0) {
            // Aucune copie n'est disponible
            return -3;
        }

        // Mettre à jour le nombre de copies disponibles
        livre.get().setNbrEmpreintes(livre.get().getNbrEmpreintes() - 1);
        livreService.update(livre.get());
        int nouvelleQuantite = (int) livre.get().getStock().getQuantite() - 1;
        livre.get().getStock().setQuantite(nouvelleQuantite);
        stockService.update(livre.get().getStock());

        // Ajouter la réservation
        LocalDateTime localDateTime = LocalDateTime.now();
        reservation.setDateReservation(localDateTime);
        reservationDao.save(reservation);
        reservation.setReference("Reservation-" + reservation.getId());
        reservationDao.save(reservation);
        return 1;
    }


    public int update(Reservation reservation){
        Reservation reservation1 = findByReference(reservation.getReference());
        if (reservation1 != null){
            if (reservation.getDateReservation() != null) {
                reservation1.setDateReservation(reservation.getDateReservation());
            }
            if (reservation.getLivre() != null) {
                reservation1.setLivre(reservation.getLivre());
            }
            if (reservation.getUtilisateur() != null) {
                reservation1.setUtilisateur(reservation.getUtilisateur());
            }
            reservationDao.save(reservation1);
            return 1;
        } else {
            reservationDao.save(reservation);
            return 2;
        }
    }

}
