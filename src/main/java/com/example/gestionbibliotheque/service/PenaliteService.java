package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.Penalite;
import com.example.gestionbibliotheque.dao.PenaliteDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PenaliteService {
    @Autowired
    private PenaliteDao penaliteDao;


    public Penalite findByReference(String reference) {
        return penaliteDao.findByReference(reference);
    }

    public List<Penalite> findByDatePenalite(LocalDateTime date) {
        return penaliteDao.findByDatePenalite(date);
    }
    @Transactional
    public int deleteByReference(String reference) {
        return penaliteDao.deleteByReference(reference);
    }

    public Penalite findByUtilisateurReference(String reference) {
        return penaliteDao.findByUtilisateurReference(reference);
    }
    @Transactional
    public int deleteByUtilisateurReference(String reference) {
        return penaliteDao.deleteByUtilisateurReference(reference);
    }

    public List<Penalite> findAll() {
        return penaliteDao.findAll();
    }
    public int save(Penalite penalite){
       if (findByReference(penalite.getReference())!=null) {
            return -2;
        } else {
            LocalDateTime localDateTime= LocalDateTime.now();
            penalite.setDatePenalite(localDateTime);
            penalite.setUtilisateur(penalite.getUtilisateur());
            penaliteDao.save(penalite);
            penalite.setReference("Penalite-"+penalite.getId());
            penaliteDao.save(penalite);
            return 1;
        }

    }
}
