package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.Librairie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrairieDao extends JpaRepository<Librairie, Long> {
    Librairie findByReference(String reference);
    Librairie findByNom(String nom);
    Librairie findByAdresse(String adresse);
    Librairie findByEmail(String email);
    int deleteByReference(String reference);

}
