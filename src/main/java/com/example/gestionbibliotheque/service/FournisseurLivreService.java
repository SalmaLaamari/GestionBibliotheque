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
        if (fournisseurLivre.getEmail()==null) {
            return -1;
        }else {
            fournisseurLivreDao.save(fournisseurLivre);
            fournisseurLivre.setReference("Fournisseur-"+fournisseurLivre.getId());
            fournisseurLivreDao.save(fournisseurLivre);
            return 1;
        }

    }

    public int update(FournisseurLivre fournisseurLivre){
        FournisseurLivre fournisseurLivre1 = findByReference(fournisseurLivre.getReference());
        if (fournisseurLivre1 != null){
            if (fournisseurLivre.getNom() != null) {
                fournisseurLivre1.setNom(fournisseurLivre.getNom());
            }
            if (fournisseurLivre.getPrenom() != null) {
                fournisseurLivre1.setPrenom(fournisseurLivre.getPrenom());
            }
            if (fournisseurLivre.getEmail() != null) {
                fournisseurLivre1.setEmail(fournisseurLivre.getEmail());
            }
            if (fournisseurLivre.getAdresse() != null) {
                fournisseurLivre1.setAdresse(fournisseurLivre.getAdresse());
            }
            if (fournisseurLivre.getTelephone() != null) {
                fournisseurLivre1.setTelephone(fournisseurLivre.getTelephone());
            }
            fournisseurLivreDao.save(fournisseurLivre1);
            return 1;
        } else {
            fournisseurLivreDao.save(fournisseurLivre);
            return 2;
        }
    }

}
