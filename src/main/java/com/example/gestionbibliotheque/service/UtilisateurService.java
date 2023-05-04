package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.Utilisateur;
import com.example.gestionbibliotheque.dao.UtilisateurDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
            LocalDateTime localDateTime= LocalDateTime.now();
            utilisateur.setDateAuthentification(localDateTime);
            utilisateurDao.save(utilisateur);
            utilisateur.setReference("User-"+utilisateur.getCin());
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
    public int update(Utilisateur utilisateur){
        Utilisateur utilisateur1 = findByReference(utilisateur.getReference());
        if (utilisateur1 != null){
            if (utilisateur.getNom() != null) {
                utilisateur1.setNom(utilisateur.getNom());
            }
            if (utilisateur.getPrenom() != null) {
                utilisateur1.setPrenom(utilisateur.getPrenom());
            }
            if (utilisateur.getEmail() != null) {
                utilisateur1.setEmail(utilisateur.getEmail());
            }
            if (utilisateur.getDateAuthentification() != null) {
                utilisateur1.setDateAuthentification(utilisateur.getDateAuthentification());
            }
            if (utilisateur.getPasseword() != null) {
                utilisateur1.setPasseword(utilisateur.getPasseword());
            }
            if (utilisateur.getRole() != null) {
                utilisateur1.setRole(utilisateur.getRole());
            }
            if (utilisateur.getCin() != null) {
                utilisateur1.setCin(utilisateur.getCin());
            }
            utilisateurDao.save(utilisateur1);
            return 1;
        } else {
            utilisateurDao.save(utilisateur);
            return 2;
        }
    }

}
