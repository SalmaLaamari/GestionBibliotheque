package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByReference(String reference);
    Utilisateur findByNom(String nom);
    Utilisateur findByPrenom(String prenom);
    Utilisateur findByEmailAndPasseword(String email, String password );
    int deleteByReference(String reference);
    Utilisateur findByEmail(String email);
}
