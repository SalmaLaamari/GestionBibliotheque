package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.FicheReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FicheReservationDao extends JpaRepository<FicheReservation,Long> {
    FicheReservation findByReference(String reference);
    List<FicheReservation> findByUtilisateurReference(String reference);
    int deleteByReference(String reference);
}
