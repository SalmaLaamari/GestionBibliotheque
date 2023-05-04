package com.example.gestionbibliotheque.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Reception {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private LocalDateTime dateReception;
    private String reference;
    private int quantitereceptione;

    public int getQuantitereceptione() {
        return quantitereceptione;
    }

    public void setQuantitereceptione(int quantitereceptione) {
        this.quantitereceptione = quantitereceptione;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDateReception() {
        return dateReception;
    }

    public void setDateReception(LocalDateTime dateReception) {
        this.dateReception = dateReception;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
