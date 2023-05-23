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

    public List<Livre> findByCategorie(String categorie) {
        return livreDao.findByCategorie(categorie);
    }

    public List<Livre> findAll() {
        return livreDao.findAll();
    }
    public  int save(Livre livre){
        if (findByReference(livre.getReference())!=null){
            return -2;
        } else if (livre.getTitre()==null) {
            return -3;
        }else {
            livre.setFournisseurLivre(livre.getFournisseurLivre());
            livre.setLibrairie(livre.getLibrairie());
            livre.setStock(livre.getStock());
            livre.setImagesrc("assets/images/Livre/" + livre.getTitre() + ".jpeg");
            livreDao.save(livre);
            livre.setReference("Livre-"+livre.getId());
            livreDao.save(livre);
            return 1;
        }

    }
    public int update(Livre livre){
        Livre livre1 = findByReference(livre.getReference());
        if (livre1 != null){
            if (livre.getTitre() != null) {
                livre1.setTitre(livre.getTitre());
            }
            if (livre.getNbrEmpreintes() != 0) {
                livre1.setNbrEmpreintes(livre.getNbrEmpreintes());
            }
            if (livre.getDatePublication() != null) {
                livre1.setDatePublication(livre.getDatePublication());
            }
            if (livre.getCategorie() != null) {
                livre1.setCategorie(livre.getCategorie());
            }
            if (livre.getAuteur() != null) {
                livre1.setAuteur(livre.getAuteur());
            }
            if (livre.getAvailabilityStatus() != null) {
                livre1.setAvailabilityStatus(livre.getAvailabilityStatus());
            }
            if (livre.getImagesrc() != null) {
                livre1.setImagesrc(livre.getImagesrc());
            }
            if (livre.getLangue() != null) {
                livre1.setLangue(livre.getLangue());
            }
            if (livre.getFournisseurLivre() != null) {
                livre1.setFournisseurLivre(livre.getFournisseurLivre());
            }
            if (livre.getLibrairie() != null) {
                livre1.setLibrairie(livre.getLibrairie());
            }
            if (livre.getStock() != null ) {
                livre1.setStock(livre.getStock());
            }
            if (livre.getReception() != null) {
                livre1.setReception(livre.getReception());
            }
            if (livre.getUtilisateur() != null) {
                livre1.setUtilisateur(livre.getUtilisateur());
            }
            livreDao.save(livre1);
            return 1;
        } else {
            livreDao.save(livre);
            return 2;
        }
    }

}
