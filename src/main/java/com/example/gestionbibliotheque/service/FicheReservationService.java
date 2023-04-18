package com.example.gestionbibliotheque.service;


import com.example.gestionbibliotheque.bean.FicheReservation;
import com.example.gestionbibliotheque.dao.FicheReservationDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FicheReservationService {
    @Autowired
    private FicheReservationDao ficheReservationDao;

    public FicheReservation findByReference(String reference) {
        return ficheReservationDao.findByReference(reference);
    }

    public FicheReservation findByUtilisateurReference(String reference) {
        return ficheReservationDao.findByUtilisateurReference(reference);
    }
    @Transactional
    public int deleteByReference(String reference) {
        return ficheReservationDao.deleteByReference(reference);
    }

    public List<FicheReservation> findAll() {
        return ficheReservationDao.findAll();
    }
    public int save(FicheReservation ficheReservation){
        if (ficheReservation.getReference()==null){
            return -1;
        }else if (findByReference(ficheReservation.getReference())!=null){
            return -2;
        }else {
            ficheReservation.setUtilisateur(ficheReservation.getUtilisateur());
            ficheReservation.setReference("FicheReser-"+ficheReservation.getId());
            ficheReservationDao.save(ficheReservation);
            return 1;
        }

    }
}
