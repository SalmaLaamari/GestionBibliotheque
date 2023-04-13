package com.example.gestionbibliotheque.bean;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String reference;
    private long total;
    private LocalDateTime dateFacture;

    @ManyToOne
    private FournisseurLivre fournisseurLivre;

    @ManyToOne
    private Paiement paiement;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public LocalDateTime getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(LocalDateTime dateFacture) {
        this.dateFacture = dateFacture;
    }

    public FournisseurLivre getFournisseurLivre() {
        return fournisseurLivre;
    }

    public void setFournisseurLivre(FournisseurLivre fournisseurLivre) {
        this.fournisseurLivre = fournisseurLivre;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }
}
