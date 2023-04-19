package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.Librairie;
import com.example.gestionbibliotheque.bean.Livre;
import com.example.gestionbibliotheque.dao.LivreDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LivreService {
    @Autowired
    private LivreDao livreDao;

    public Livre findByReference(String reference) {
        return livreDao.findByReference(reference);
    }

    public Livre findByAuteur(String auteur) {
        return livreDao.findByAuteur(auteur);
    }

    public Livre findByTitre(String titre) {
        return livreDao.findByTitre(titre);
    }

    public List<Livre> findByBranche(String branche) {
        return livreDao.findByBranche(branche);
    }

    public List<Livre> findByFournisseurLivreReference(String reference) {
        return livreDao.findByFournisseurLivreReference(reference);
    }

    public List<Livre> findByStockReference(String reference) {
        return livreDao.findByStockReference(reference);
    }

    public List<Livre> findByDatePublication(LocalDateTime date) {
        return livreDao.findByDatePublication(date);
    }
    @Transactional
    public int deleteByReference(String reference) {
        return livreDao.deleteByReference(reference);
    }

    public List<Livre> findAll() {
        return livreDao.findAll();
    }
    public  int save(Livre livre){
        if (livre.getReception()==null){
            return -1;
        }else if (findByReference(livre.getReference())!=null){
            return -2;
        } else if (livre.getTitre()==null) {
            return -3;
        }else if (livre.getAuteur()==null) {
            return -4;
        }else if (livre.getBranche()==null) {
            return -4;
        }else {
            livre.setFournisseurLivre(livre.getFournisseurLivre());
            livre.setLibrairie(livre.getLibrairie());
            livre.setStock(livre.getStock());
            livre.setReference("Livre-"+livre.getId());
            livreDao.save(livre);
            return 1;
        }

    }
}
