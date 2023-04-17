package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LivreDao extends JpaRepository<Livre,Long> {
    Livre findByReference(String reference);
    Livre findByBookname(String bookname);
    Livre findByAuteur(String auteur);
    Livre findByTitre(String titre);
    List<Livre> findByBranche(String branche);
    List<Livre> findByFournisseurLivreReference(String reference);
    List<Livre> findByStockReference(String reference);
    List<Livre> findByDatePublication(LocalDateTime date);
    int deleteByReference(String reference);


}
