package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.FournisseurLivre;
import com.example.gestionbibliotheque.dao.FournisseurLivreDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurLivreService {
    @Autowired
    private FournisseurLivreDao fournisseurLivreDao;

    public FournisseurLivre findByReference(String reference) {
        return fournisseurLivreDao.findByReference(reference);
    }

    public FournisseurLivre findByNom(String nom) {
        return fournisseurLivreDao.findByNom(nom);
    }

    public FournisseurLivre findByPrenom(String prenom) {
        return fournisseurLivreDao.findByPrenom(prenom);
    }

    public FournisseurLivre findByEmail(String email) {
        return fournisseurLivreDao.findByEmail(email);
    }

    public FournisseurLivre findByAdresse(String adresse) {
        return fournisseurLivreDao.findByAdresse(adresse);
    }

    public FournisseurLivre findByTelephone(String telephone) {
        return fournisseurLivreDao.findByTelephone(telephone);
    }
    @Transactional
    public int deleteByReference(String reference) {
        return fournisseurLivreDao.deleteByReference(reference);
    }

    public List<FournisseurLivre> findAll() {
        return fournisseurLivreDao.findAll();
    }
    public  int save(FournisseurLivre fournisseurLivre){
        if (fournisseurLivre.getReference()==null){
            return -1;
        } else if (fournisseurLivre.getNom()==null && fournisseurLivre.getPrenom()==null) {
            return -2;
        } else if (findByReference(fournisseurLivre.getReference())!=null) {
            return -3;
        }else {
            fournisseurLivre.setReference("Fournisseur-"+fournisseurLivre.getId());
            fournisseurLivreDao.save(fournisseurLivre);
            return 1;
        }

    }
}
