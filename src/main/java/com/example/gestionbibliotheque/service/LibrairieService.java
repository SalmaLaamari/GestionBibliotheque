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
        if (librairie.getNom()==null){
            return -2;
        }else if (librairie.getEmail()==null){
            return -3;
        }else {
            librairieDao.save(librairie);
            librairie.setReference("Librairie-"+librairie.getId());
            librairieDao.save(librairie);
            return 1;

        }
    }
    public int update(Librairie librairie){
        Librairie librairie1 = findByReference(librairie.getReference());
        if (librairie1 != null){
            if (librairie.getNom() != null) {
                librairie1.setNom(librairie.getNom());
            }
            if (librairie.getAdresse() != null) {
                librairie1.setAdresse(librairie.getAdresse());
            }
            if (librairie.getTelephone() != null) {
                librairie1.setTelephone(librairie.getTelephone());
            }
            if (librairie.getEmail() != null) {
                librairie1.setEmail(librairie.getEmail());
            }
            librairieDao.save(librairie1);
            return 1;
        } else {
            librairieDao.save(librairie);
            return 2;
        }
    }

}
