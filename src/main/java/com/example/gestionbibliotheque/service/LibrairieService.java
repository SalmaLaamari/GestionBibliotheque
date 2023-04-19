package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.Librairie;
import com.example.gestionbibliotheque.dao.LibrairieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrairieService {
    @Autowired
    private LibrairieDao librairieDao;

    public Librairie findByReference(String reference) {
        return librairieDao.findByReference(reference);
    }

    public Librairie findByNom(String nom) {
        return librairieDao.findByNom(nom);
    }

    public Librairie findByAdresse(String adresse) {
        return librairieDao.findByAdresse(adresse);
    }

    public Librairie findByEmail(String email) {
        return librairieDao.findByEmail(email);
    }

    public int deleteByReference(String reference) {
        return librairieDao.deleteByReference(reference);
    }

    public List<Librairie> findAll() {
        return librairieDao.findAll();
    }
    public int save(Librairie librairie){
        if (librairie.getReference()==null){
            return -1;
        }else if (librairie.getNom()==null){
            return -2;
        }else if (librairie.getEmail()==null){
            return -3;
        }else {
            librairie.setReference("Librairie-"+librairie.getId());
            librairieDao.save(librairie);
            return 1;

        }
    }
}
