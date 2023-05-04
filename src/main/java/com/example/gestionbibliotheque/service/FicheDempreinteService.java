package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.FicheEmpreinte;
import com.example.gestionbibliotheque.dao.FicheDempreinteDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FicheDempreinteService {
    @Autowired
    private FicheDempreinteDao ficheDempreinteDao;

    public FicheEmpreinte findByReference(String reference) {
        return ficheDempreinteDao.findByReference(reference);
    }

    public List<FicheEmpreinte> findByUtilisateurReference(String reference) {
        return ficheDempreinteDao.findByUtilisateurReference(reference);
    }

    public FicheEmpreinte findByDateRetour(LocalDateTime date) {
        return ficheDempreinteDao.findByDateRetour(date);
    }
    @Transactional
    public int deleteByReference(String reference) {
        return ficheDempreinteDao.deleteByReference(reference);
    }

    public List<FicheEmpreinte> findAll() {
        return ficheDempreinteDao.findAll();
    }
    public int save(FicheEmpreinte ficheEmpreinte){
            ficheEmpreinte.setUtilisateur(ficheEmpreinte.getUtilisateur());
            ficheDempreinteDao.save(ficheEmpreinte);
            LocalDateTime localDateTime = LocalDateTime.now().plusWeeks(1);
            ficheEmpreinte.setDateRetour(localDateTime);
            ficheEmpreinte.setReference("FicheEmpr-"+ficheEmpreinte.getId());
            ficheDempreinteDao.save(ficheEmpreinte);
            return 1;

    }
    public int update(FicheEmpreinte ficheEmpreinte){
        FicheEmpreinte ficheEmpreinte1 = findByReference(ficheEmpreinte.getReference());
        if (ficheEmpreinte1 != null){
            if (ficheEmpreinte.getDateRetour() != null) {
                ficheEmpreinte1.setDateRetour(ficheEmpreinte.getDateRetour());
            }
            if (ficheEmpreinte.getUtilisateur() != null) {
                ficheEmpreinte1.setUtilisateur(ficheEmpreinte.getUtilisateur());
            }
            ficheDempreinteDao.save(ficheEmpreinte1);
            return 1;
        } else {
            ficheDempreinteDao.save(ficheEmpreinte);
            return 2;
        }
    }

}
