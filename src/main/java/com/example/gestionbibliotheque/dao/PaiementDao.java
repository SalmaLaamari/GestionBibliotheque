package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PaiementDao extends JpaRepository<Paiement,Long> {
    Paiement findByReference(String reference);
   List<Paiement> findByDatePaiement(LocalDateTime date);
    int deleteByReference(String reference);
}
