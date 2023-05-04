package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.CategorieCours;
import com.example.gestionbibliotheque.bean.CategorieEvent;
import com.example.gestionbibliotheque.dao.CategorieEventDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieEventService {
    @Autowired
    private CategorieEventDao categorieEventDao;

    public CategorieEvent findByReference(String reference) {
        return categorieEventDao.findByReference(reference);
    }

    public CategorieEvent findByNom(String nom) {
        return categorieEventDao.findByNom(nom);
    }

    @Transactional
    public int deleteByReference(String reference) {
        return categorieEventDao.deleteByReference(reference);
    }

    @Transactional
    public int deleteByNom(String nom) {
        return categorieEventDao.deleteByNom(nom);
    }
    public List<CategorieEvent> findAll() {
        return categorieEventDao.findAll();
    }
    public int save(CategorieEvent categorieEvent){
        if (categorieEvent.getNom()==null) {
            return -1;
        } else  {
            categorieEventDao.save(categorieEvent);
            categorieEvent.setReference("Categorie-"+categorieEvent.getId());
            categorieEventDao.save(categorieEvent);
            return 1;
        }

    }
    public int update(CategorieEvent categorieEvent) {
        CategorieEvent categorieEvent1 = findByReference(categorieEvent.getReference());
        if (categorieEvent1 != null) {
            if (categorieEvent.getNom() != null) {
                categorieEvent1.setNom(categorieEvent.getNom());
            }
            categorieEventDao.save(categorieEvent1);
            return 1;
        } else {
            categorieEventDao.save(categorieEvent);
            return 2;
        }
    }


}
