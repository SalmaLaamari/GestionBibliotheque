package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.CategorieLivre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieLivreDao extends JpaRepository<CategorieLivre, Long> {
    CategorieLivre findByReference(String reference);
    CategorieLivre findByNom(String nom);
    int deleteByReference(String reference);
    int deleteByNom(String nom);
}
