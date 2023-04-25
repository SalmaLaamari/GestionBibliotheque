package com.example.gestionbibliotheque.service;


import com.example.gestionbibliotheque.bean.FicheReservation;
import com.example.gestionbibliotheque.dao.FicheReservationDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FicheReservationService {
    @Autowired
    private FicheReservationDao ficheReservationDao;

    public FicheReservation findByReference(String reference) {
        return ficheReservationDao.findByReference(reference);
    }

    public List<FicheReservation> findByUtilisateurReference(String reference) {
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
            ficheReservation.setUtilisateur(ficheReservation.getUtilisateur());
            ficheReservationDao.save(ficheReservation);
            LocalDateTime localDateTime = LocalDateTime.now();
            ficheReservation.setDateReservation(localDateTime);
            ficheReservation.setReference("FicheReser-"+ficheReservation.getId());
            ficheReservationDao.save(ficheReservation);
            return 1;


    }
}
