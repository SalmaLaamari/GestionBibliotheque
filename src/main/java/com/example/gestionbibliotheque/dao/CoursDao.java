package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursDao extends JpaRepository<Cours,Long> {
    Cours findByReference(String reference);
    Cours findByLien(String lien);
    Cours findBySource(String Source);
    Cours findByDescription(String description);
    int deleteByReference(String reference);

}
