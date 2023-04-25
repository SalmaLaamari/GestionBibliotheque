package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface CoursDao extends JpaRepository<Cours,Long> {
    Cours findByReference(String reference);
    Cours findByLien(String lien);
    List<Cours> findBySource(String source);
    Cours findByDescription(String description);
    int deleteByReference(String reference);

}
