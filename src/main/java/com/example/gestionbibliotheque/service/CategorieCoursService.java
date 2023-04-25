package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.CategorieCours;
import com.example.gestionbibliotheque.dao.CategorieCoursDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategorieCoursService {
    @Autowired
    private CategorieCoursDao categorieCoursDao;

    public CategorieCours findByReference(String reference) {
        return categorieCoursDao.findByReference(reference);
    }

    public List<CategorieCours> findByNom(String nom) {
        return categorieCoursDao.findByNom(nom);
    }

    @Transactional
    public int deleteByReference(String reference) {
        return categorieCoursDao.deleteByReference(reference);
    }

    public int deleteByNom(String nom) {
        return categorieCoursDao.deleteByNom(nom);
    }

    public List<CategorieCours> findAll() {
        return categorieCoursDao.findAll();
    }
    public int save(CategorieCours categorieCours){
        if (categorieCours.getNom()==null) {
            return -1;
        } else  {
            categorieCoursDao.save(categorieCours);
            categorieCours.setReference("Categorie-"+categorieCours.getId());
            categorieCoursDao.save(categorieCours);
            return 1;
        }

    }
}
