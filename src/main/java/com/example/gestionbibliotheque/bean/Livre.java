package com.example.gestionbibliotheque.bean;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String reference;
    private String auteur;
    private String titre = "";
    private Boolean availabilityStatus;
    private String imagesrc;
    private String langue;
    private int nbrEmpreintes;
    @ManyToOne
    private CategorieLivre categorieLivre;

    @ManyToOne
    private FournisseurLivre fournisseurLivre;

    @ManyToOne
    private Librairie librairie;

    @ManyToOne
    private Stock stock;

    @ManyToOne
    private Reception reception;


    private LocalDateTime datePublication;
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

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }


    public Boolean getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(Boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public FournisseurLivre getFournisseurLivre() {
        return fournisseurLivre;
    }

    public void setFournisseurLivre(FournisseurLivre fournisseurLivre) {
        this.fournisseurLivre = fournisseurLivre;
    }

    public Librairie getLibrairie() {
        return librairie;
    }

    public void setLibrairie(Librairie librairie) {
        this.librairie = librairie;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Reception getReception() {
        return reception;
    }

    public void setReception(Reception reception) {
        this.reception = reception;
    }

    public LocalDateTime getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDateTime datePublication) {
        this.datePublication = datePublication;
    }

    public String getImagesrc() {
        return imagesrc;
    }

    public void setImagesrc(String imagesrc) {
        this.imagesrc = imagesrc;
    }

    public CategorieLivre getCategorieLivre() {
        return categorieLivre;
    }

    public void setCategorieLivre(CategorieLivre categorieLivre) {
        this.categorieLivre = categorieLivre;
    }

    public int getNbrEmpreintes() {
        return nbrEmpreintes;
    }

    public void setNbrEmpreintes(int nbrEmpreintes) {
        this.nbrEmpreintes = nbrEmpreintes;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }
}
