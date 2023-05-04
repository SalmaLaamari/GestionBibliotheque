package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.Cours;
import com.example.gestionbibliotheque.dao.CoursDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursService {
    @Autowired
    private CoursDao coursDao;
    @Autowired
    private CategorieCoursService categorieCoursService;

    public Cours findByReference(String reference) {
        return coursDao.findByReference(reference);
    }

    public Cours findByLien(String lien) {
        return coursDao.findByLien(lien);
    }

    public List<Cours> findBySource(String source) {
        return coursDao.findBySource(source);
    }

    public List<Cours> findByCategorieCoursNom(String nom) {
        return coursDao.findByCategorieCoursNom(nom);
    }

    public Cours findByDescription(String description) {
        return coursDao.findByDescription(description);
    }
    @Transactional
    public int deleteByReference(String reference) {
        return coursDao.deleteByReference(reference);
    }

    public List<Cours> findAll() {
        return coursDao.findAll();
    }
    public int save(Cours cours){
        if (cours.getLien()==null) {
            return -1 ;
        } else if (cours.getSource()==null) {
            return -2;
        }else if (cours.getDescription()==null) {
            return -3;
        }else if (cours.getImageCour()==null) {
            return -4;
        }else {
            cours.setCategorieCours(cours.getCategorieCours());
            categorieCoursService.save(cours.getCategorieCours());
            coursDao.save(cours);
            cours.setReference("Cour-"+cours.getId());
            coursDao.save(cours);
            return 1;
        }

    }
    public int update(Cours cours){
        Cours cours1 = findByReference(cours.getReference());
        if (cours1 != null){
            if (cours.getLien() != null) {
                cours1.setLien(cours.getLien());
            }
            if (cours.getDescription() != null) {
                cours1.setDescription(cours.getDescription());
            }
            if (cours.getSource() != null) {
                cours1.setSource(cours.getSource());
            }
            if (cours.getImageCour() != null) {
                cours1.setImageCour(cours.getImageCour());
            }
            if (cours.getCategorieCours() != null) {
                cours1.setCategorieCours(cours.getCategorieCours());
            }
            coursDao.save(cours1);
            return 1;
        } else {
            coursDao.save(cours);
            return 2;
        }
    }

}
