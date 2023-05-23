package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.FournisseurLivre;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FournisseurLivreDao extends JpaRepository<FournisseurLivre,Long> {
    FournisseurLivre findByReference(String reference);
    FournisseurLivre findByNom(String nom);
    FournisseurLivre findByPrenom(String prenom);
    FournisseurLivre findByEmail(String email);
    FournisseurLivre findByAdresse(String adresse);
    FournisseurLivre findByTelephone(String telephone);
    int deleteByReference(String reference);
}
