package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.FicheEmpreinte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FicheDempreinteDao extends JpaRepository<FicheEmpreinte,Long> {
    FicheEmpreinte findByReference(String reference);
    List<FicheEmpreinte> findByUtilisateurReference(String reference);
    FicheEmpreinte findByDateRetour(LocalDateTime date);
    int deleteByReference(String reference);
}
