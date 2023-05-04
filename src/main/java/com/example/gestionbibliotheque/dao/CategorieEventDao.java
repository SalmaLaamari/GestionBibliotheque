package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.CategorieCours;
import com.example.gestionbibliotheque.bean.CategorieEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieEventDao extends JpaRepository<CategorieEvent,Long> {
    CategorieEvent findByReference(String reference);
    CategorieEvent findByNom(String nom);
    int deleteByReference(String reference);
    int deleteByNom(String nom);

}
