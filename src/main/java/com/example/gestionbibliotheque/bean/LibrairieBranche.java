package com.example.gestionbibliotheque.bean;

import jakarta.persistence.*;

import java.time.format.DecimalStyle;

@Entity
public class LibrairieBranche {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String name ;
    private String email ;
    private String description ;
    private String reference ;
    @ManyToOne
    private Librairie librairie;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Librairie getLibrairie() {
        return librairie;
    }

    public void setLibrairie(Librairie librairie) {
        this.librairie = librairie;
    }
}
