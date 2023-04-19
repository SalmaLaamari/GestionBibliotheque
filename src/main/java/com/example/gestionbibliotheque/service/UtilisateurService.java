package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.Utilisateur;
import com.example.gestionbibliotheque.dao.UtilisateurDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurDao utilisateurDao;

    public Utilisateur findByReference(String reference) {
        return utilisateurDao.findByReference(reference);
    }

    public Utilisateur findByNom(String nom) {
        return utilisateurDao.findByNom(nom);
    }

    public Utilisateur findByPrenom(String prenom) {
        return utilisateurDao.findByPrenom(prenom);
    }

    public Utilisateur findByEmailAndPasseword(String email, String password) {
        return utilisateurDao.findByEmailAndPasseword(email, password);
    }

    public Utilisateur findByCin(String cin) {
        return utilisateurDao.findByCin(cin);
    }

    @Transactional
    public int deleteByReference(String reference) {
        return utilisateurDao.deleteByReference(reference);
    }

    public List<Utilisateur> findAll() {
        return utilisateurDao.findAll();
    }

    public Utilisateur findByEmail(String email) {
        return utilisateurDao.findByEmail(email);
    }

    public int createUser(Utilisateur utilisateur) {
        if (findByEmail(utilisateur.getEmail()) != null) {
            return -1;
        } else {
            utilisateurDao.save(utilisateur);
            return 1;
        }
    }
    public int loginUser(String email, String password) {
        Utilisateur utilisateur = findByEmail(email);
        if (utilisateur == null) {
            return -1;
        }
        if (password == utilisateur.getPasseword()) {
            return -2;
        }
        return 1;
    }

}
