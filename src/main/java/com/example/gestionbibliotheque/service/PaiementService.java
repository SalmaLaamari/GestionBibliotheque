package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.Paiement;
import com.example.gestionbibliotheque.dao.PaiementDao;
import com.example.gestionbibliotheque.dao.ReceptionDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaiementService {
    @Autowired
    private PaiementDao paiementDao;
    @Autowired
    private ReceptionDao receptionDao;

    public Paiement findByReference(String reference) {
        return paiementDao.findByReference(reference);
    }

    public List<Paiement> findByDatePaiement(LocalDateTime date) {
        return paiementDao.findByDatePaiement(date);
    }
    @Transactional
    public int deleteByReference(String reference) {
        return paiementDao.deleteByReference(reference);
    }

    public List<Paiement> findAll() {
        return paiementDao.findAll();
    }
    public int save(Paiement paiement){
        if (findByReference(paiement.getReference())!=null) {
            return -2;
        }else {
            LocalDateTime localDateTime=LocalDateTime.now();
            paiement.setDatePaiement(localDateTime);
            paiementDao.save(paiement);
            paiement.setReference("Paiement-"+paiement.getId());
            paiementDao.save(paiement);
            return 1;
        }

    }
}
