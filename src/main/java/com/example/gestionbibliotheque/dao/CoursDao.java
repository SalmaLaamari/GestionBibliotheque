package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoursDao extends JpaRepository<Cours,Long> {
    Cours findByReference(String reference);
    Cours findByLien(String lien);

    @Override
    Optional<Cours> findById(Long id);
    Cours findByTitre(String titre);

    List<Cours> findByCategorie(String categorie);
    List<Cours> findBySource(String source);
    Cours findByDescription(String description);
    int deleteByReference(String reference);

}
