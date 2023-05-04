package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.CategorieEvent;
import com.example.gestionbibliotheque.bean.CategorieLivre;
import com.example.gestionbibliotheque.dao.CategorieLivreDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieLivreService {
    @Autowired
    private CategorieLivreDao categorieLivreDao;
    public CategorieLivre findByReference(String reference) {
        return categorieLivreDao.findByReference(reference);
    }

    public CategorieLivre findByNom(String nom) {
        return categorieLivreDao.findByNom(nom);
    }

    @Transactional
    public int deleteByReference(String reference) {
        return categorieLivreDao.deleteByReference(reference);
    }

    @Transactional
    public int deleteByNom(String nom) {
        return categorieLivreDao.deleteByNom(nom);
    }

    public List<CategorieLivre> findAll() {
        return categorieLivreDao.findAll();
    }
    public int save(CategorieLivre categorieLivre){
        if (categorieLivre.getNom()==null) {
            return -1;
        } else  {
            categorieLivreDao.save(categorieLivre);
            categorieLivre.setReference("Categorie-"+categorieLivre.getId());
            categorieLivreDao.save(categorieLivre);
            return 1;
        }

    }

    public int update(CategorieLivre categorieLivre) {
        CategorieLivre categorieLivre1 = categorieLivreDao.findByReference(categorieLivre.getReference());
        if (categorieLivre1 != null) {
            if (categorieLivre.getNom() != null) {
                categorieLivre1.setNom(categorieLivre.getNom());
            }
            categorieLivreDao.save(categorieLivre1);
            return 1;
        } else {
            categorieLivreDao.save(categorieLivre);
            return 2;
        }
    }

}
