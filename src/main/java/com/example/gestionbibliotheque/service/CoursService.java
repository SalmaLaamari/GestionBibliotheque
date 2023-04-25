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

    public Cours findByReference(String reference) {
        return coursDao.findByReference(reference);
    }

    public Cours findByLien(String lien) {
        return coursDao.findByLien(lien);
    }

    public List<Cours> findBySource(String source) {
        return coursDao.findBySource(source);
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
            coursDao.save(cours);
            cours.setReference("Cour-"+cours.getId());
            coursDao.save(cours);
            return 1;
        }

    }
}
