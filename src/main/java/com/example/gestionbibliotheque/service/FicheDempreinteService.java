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

    public FicheEmpreinte findByUtilisateurReference(String reference) {
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
        if (ficheEmpreinte.getReference()==null){
            return -1;
        } else if (findByReference(ficheEmpreinte.getReference())!=null) {
            return -2;
        }else {
            ficheEmpreinte.setUtilisateur(ficheEmpreinte.getUtilisateur());
            ficheEmpreinte.setReference("FicheEmpr-"+ficheEmpreinte.getId());
            ficheDempreinteDao.save(ficheEmpreinte);
            return 1;
        }

    }
}
