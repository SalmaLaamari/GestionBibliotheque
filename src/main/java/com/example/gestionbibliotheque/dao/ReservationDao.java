package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.Reservation;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationDao extends JpaRepository<Reservation,Long> {
    List<Reservation> findByDateReservation(LocalDateTime date);
    Reservation findByReference(String reference);
    Reservation findByLivreReference(String reference);
    Reservation findByUtilisateurReference(String reference);
    Reservation findByUtilisateurCin(String cin);
    Reservation findByUtilisateurCinAndLivreTitre(String cin, String titre);
    int deleteByReference(String reference);
    int deleteByUtilisateurReference(String reference);
    int deleteByLivreReference(String reference);

}
