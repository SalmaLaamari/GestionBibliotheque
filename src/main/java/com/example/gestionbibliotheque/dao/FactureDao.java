package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FactureDao extends JpaRepository<Facture,Long> {
    Facture findByReference(String reference);
   List<Facture>  findByFournisseurLivreReference(String reference);
   List<Facture> findByTotal(Long total);
   List<Facture> findByTotalGreaterThan(Long total);
   List<Facture> findByTotalLessThan(Long total);
   List<Facture> findByPaiementReference(String reference);
   int deleteByReference(String reference);


}
