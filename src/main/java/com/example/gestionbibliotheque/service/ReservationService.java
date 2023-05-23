package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.Reservation;
import com.example.gestionbibliotheque.bean.Utilisateur;
import com.example.gestionbibliotheque.dao.ReservationDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationDao reservationDao;
    @Autowired
    private UtilisateurService utilisateurService;

    public Reservation findByReference(String reference) {
        return reservationDao.findByReference(reference);
    }

    public List<Reservation> findByDateReservation(LocalDateTime date) {
        return reservationDao.findByDateReservation(date);
    }


    public Reservation findByLivreReference(String reference) {
        return reservationDao.findByLivreReference(reference);
    }

    public Reservation findByUtilisateurReference(String reference) {
        return reservationDao.findByUtilisateurReference(reference);
    }

    public Reservation findByUtilisateurCin(String cin) {
        return reservationDao.findByUtilisateurCin(cin);
    }

    @Transactional
    public int deleteByReference(String reference) {
        return reservationDao.deleteByReference(reference);
    }
    @Transactional
    public int deleteByUtilisateurReference(String reference) {
        return reservationDao.deleteByUtilisateurReference(reference);
    }

    public Reservation findByUtilisateurCinAndLivreTitre(String cin, String titre) {
        return reservationDao.findByUtilisateurCinAndLivreTitre(cin, titre);
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
        Reservation reservation1 = reservationDao.findByUtilisateurCin(reservation.getUtilisateur().getCin());
        LocalDateTime localDateTimee = LocalDateTime.now();
        if (reservation1 != null && reservation1.getDateRetour().isBefore(localDateTimee)) {
            return -1;
        }
        Reservation reservation2 = reservationDao.findByUtilisateurCinAndLivreTitre(reservation.getUtilisateur().getCin(), reservation.getLivre().getTitre());
        if (reservation2 != null){
            return -2;
        }
        else {
            Utilisateur utilisateur = utilisateurService.findByCin(reservation.getUtilisateur().getCin());
            reservation.setUtilisateur(utilisateur);
            LocalDateTime localDateTime = LocalDateTime.now();
            reservation.setDateReservation(localDateTime);
            LocalDateTime localDateTime1 = LocalDateTime.now().plusWeeks(1);
            reservation.setDateRetour(localDateTime1);
            reservationDao.save(reservation);
            reservation.setReference("Reservation-" + reservation.getId());
            reservationDao.save(reservation);
            return 1;
        }
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
