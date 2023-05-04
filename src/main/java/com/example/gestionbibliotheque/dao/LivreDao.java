package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface LivreDao extends JpaRepository<Livre,Long> {
    Livre findByReference(String reference);
    List<Livre> findByAuteur(String auteur);
    Optional<Livre> findByTitre(String titre);
    List<Livre> findByLangue(String langue);
    List<Livre> findByCategorieLivreNom(String nom);
    List<Livre> findByFournisseurLivreReference(String reference);
    List<Livre> findByStockReference(String reference);
    List<Livre> findByDatePublication(LocalDateTime date);


}
