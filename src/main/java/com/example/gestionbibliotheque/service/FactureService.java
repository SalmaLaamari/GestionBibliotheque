package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.Facture;
import com.example.gestionbibliotheque.bean.FournisseurLivre;
import com.example.gestionbibliotheque.dao.FactureDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FactureService {
    @Autowired
    private FactureDao factureDao;

    public Facture findByReference(String reference) {
        return factureDao.findByReference(reference);
    }

    public List<Facture> findByFournisseurLivreReference(String reference) {
        return factureDao.findByFournisseurLivreReference(reference);
    }

    public List<Facture> findByTotal(double total) {
        return factureDao.findByTotal(total);
    }

    public List<Facture> findByTotalGreaterThan(double total) {
        return factureDao.findByTotalGreaterThan(total);
    }

    public List<Facture> findByTotalLessThan(double total) {
        return factureDao.findByTotalLessThan(total);
    }

    public List<Facture> findByPaiementReference(String reference) {
        return factureDao.findByPaiementReference(reference);
    }
    @Transactional
    public int deleteByReference(String reference) {
        return factureDao.deleteByReference(reference);
    }
    public List<Facture> findAll() {
        return factureDao.findAll();
    }
    public int save(Facture facture){
        if (facture.getTotal()<=0){
            return -1;
        }else {
            facture.setFournisseurLivre(facture.getFournisseurLivre());
            factureDao.save(facture);
            facture.setReference("Facture-"+facture.getId());
            factureDao.save(facture);
            return 1;
        }

    }
    public int update(Facture facture){
        Facture facture1 = findByReference(facture.getReference());
        if (facture1 != null){
            if (facture.getTotal() != 0) {
                facture1.setTotal(facture.getTotal());
            }
            if (facture.getDateFacture() != null) {
                facture1.setDateFacture(facture.getDateFacture());
            }
            if (facture.getFournisseurLivre() != null) {
                facture1.setFournisseurLivre(facture.getFournisseurLivre());
            }
            if (facture.getPaiement() != null) {
                facture1.setPaiement(facture.getPaiement());
            }
            factureDao.save(facture1);
            return 1;
        } else {
            factureDao.save(facture);
            return 2;
        }
    }


}
