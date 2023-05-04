package com.example.gestionbibliotheque.bean;

import jakarta.persistence.*;


@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String reference;
    private String lien;
    private String description;
    private String source;
    private String imageCour;
    @ManyToOne
    private CategorieCours categorieCours;
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

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getImageCour() {
        return imageCour;
    }

    public void setImageCour(String imageCour) {
        this.imageCour = imageCour;
    }

    public CategorieCours getCategorieCours() {
        return categorieCours;
    }

    public void setCategorieCours(CategorieCours categorieCours) {
        this.categorieCours = categorieCours;
    }
}
