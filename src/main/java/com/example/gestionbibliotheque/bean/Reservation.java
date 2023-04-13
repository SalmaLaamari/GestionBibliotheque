package com.example.gestionbibliotheque.bean;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime dateReservation;
    private LocalDateTime dateRendement;
    private String reference;
    @ManyToOne
    private Livre livre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDateTime dateReservation) {
        this.dateReservation = dateReservation;
    }

    public LocalDateTime getDateRendement() {
        return dateRendement;
    }

    public void setDateRendement(LocalDateTime dateRendement) {
        this.dateRendement = dateRendement;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
