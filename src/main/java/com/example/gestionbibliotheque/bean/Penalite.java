package com.example.gestionbibliotheque.bean;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Penalite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double montant;
    private LocalDateTime datePenalite;
    private String reference;
    @ManyToOne
    private Utilisateur utilisateur;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public LocalDateTime getDatePenalite() {
        return datePenalite;
    }

    public void setDatePenalite(LocalDateTime datePenalite) {
        this.datePenalite = datePenalite;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }


}
