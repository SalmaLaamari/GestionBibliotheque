package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.CategorieCours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieCoursDao extends JpaRepository<CategorieCours,Long> {
    CategorieCours findByReference(String reference);
    CategorieCours findByNom(String nom);
    int deleteByReference(String reference);
    int deleteByNom(String nom);
}
