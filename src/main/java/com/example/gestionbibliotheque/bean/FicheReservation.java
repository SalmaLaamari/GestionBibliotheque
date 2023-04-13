package com.example.gestionbibliotheque.bean;

import jakarta.persistence.*;

@Entity
public class FicheReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    @ManyToOne
    private Utilisateur utilisateur;
}
