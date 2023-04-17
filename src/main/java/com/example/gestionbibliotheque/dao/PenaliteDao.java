package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.Penalite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PenaliteDao extends JpaRepository<Penalite,Long> {
    Penalite findByReference(String reference);
    List<Penalite> findByDatePenalite(LocalDateTime date);
    int deleteByReference(String reference);
    Penalite findByUtilisateurReference(String reference);
    int deleteByUtilisateurReference(String reference);
}
