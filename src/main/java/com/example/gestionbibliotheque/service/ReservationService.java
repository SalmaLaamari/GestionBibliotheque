package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.Reservation;
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

    public Reservation findByReference(String reference) {
        return reservationDao.findByReference(reference);
    }

    public List<Reservation> findByDateReservation(LocalDateTime date) {
        return reservationDao.findByDateReservation(date);
    }

    public List<Reservation> findByDateRendement(LocalDateTime date) {
        return reservationDao.findByDateRendement(date);
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
    public int save(Reservation reservation){
        if (reservation.getReference()==null){
            return -1;
        }else if (findByReference(reservation.getReference())!=null){
            return -2;
        }else {
            reservation.setLivre(reservation.getLivre());
            reservation.setUtilisateur(reservation.getUtilisateur());
            reservation.setReference("Reservation-"+reservation.getId());
            reservationDao.save(reservation);
            return 1;

        }
    }
}
