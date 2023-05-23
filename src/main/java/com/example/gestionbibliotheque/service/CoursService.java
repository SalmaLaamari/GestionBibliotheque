package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.Cours;
import com.example.gestionbibliotheque.dao.CoursDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursService {
    @Autowired
    private CoursDao coursDao;

    public Cours findByReference(String reference) {
        return coursDao.findByReference(reference);
    }

    public Optional<Cours> findById(Long id) {
        return coursDao.findById(id);
    }

    public Cours findByTitre(String titre) {
        return coursDao.findByTitre(titre);
    }

    public Cours findByLien(String lien) {
        return coursDao.findByLien(lien);
    }

    public List<Cours> findBySource(String source) {
        return coursDao.findBySource(source);
    }

    public List<Cours> findByCategorie(String categorie) {
        return coursDao.findByCategorie(categorie);
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
        }else {
            cours.setImageCour("assets/images/Cours/" + cours.getTitre() + ".jpeg");
            coursDao.save(cours);
            cours.setReference("Cour-"+cours.getId());
            coursDao.save(cours);
            return 1;
        }

    }
    public int update(Cours cours){
        Cours cours1 = findByReference(cours.getReference());
        if (cours1 != null){

            if (cours.getTitre() != null) {
                cours1.setTitre(cours.getTitre());
            }

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

            if (cours.getCategorie() != null) {
                cours1.setCategorie(cours.getCategorie());
            }
            coursDao.save(cours1);
            return 1;
        } else {
            coursDao.save(cours);
            return 2;
        }
    }

}
