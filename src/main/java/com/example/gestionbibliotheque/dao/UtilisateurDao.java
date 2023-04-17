package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByReference(String reference);
    Utilisateur findByNom(String nom);
    Utilisateur findByPrenom(String nom);
    Utilisateur findByEmail(String prenom);
    int deleteByReference(String reference);
}
