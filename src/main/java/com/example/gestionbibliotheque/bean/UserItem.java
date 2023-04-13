package com.example.gestionbibliotheque.bean;

import jakarta.persistence.*;

@Entity
public class UserItem {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
     @ManyToOne
     private Utilisateur utilisateur;
     @ManyToOne
     private Livre livre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }
}
