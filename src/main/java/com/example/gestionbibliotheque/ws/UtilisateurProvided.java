package com.example.gestionbibliotheque.ws;

import com.example.gestionbibliotheque.bean.Utilisateur;
import com.example.gestionbibliotheque.service.UtilisateurService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("GestionBiblio/Utilisateur")
public class UtilisateurProvided {
    @Autowired
    private UtilisateurService utilisateurService;
    @GetMapping("/Reference/{reference}")
    public Utilisateur findByReference(@PathVariable String reference) {
        return utilisateurService.findByReference(reference);
    }
    @GetMapping("/Nom/{nom}")
    public Utilisateur findByNom(@PathVariable String nom) {
        return utilisateurService.findByNom(nom);
    }
    @GetMapping("/Prenom/{prenom}")
    public Utilisateur findByPrenom(@PathVariable String prenom) {
        return utilisateurService.findByPrenom(prenom);
    }
    @GetMapping("/Email/{email}/Password/{password}")
    public Utilisateur findByEmailAndPasseword(@PathVariable String email,@PathVariable String password) {
        return utilisateurService.findByEmailAndPasseword(email, password);
    }
    @GetMapping("/Cin/{cin}")
    public Utilisateur findByCin(@PathVariable String cin) {
        return utilisateurService.findByCin(cin);
    }
    @DeleteMapping("/Reference/{reference}")
    @Transactional
    public int deleteByReference(@PathVariable String reference) {
        return utilisateurService.deleteByReference(reference);
    }
    @GetMapping("/")
    public List<Utilisateur> findAll() {
        return utilisateurService.findAll();
    }
    @GetMapping("/Email/{email}")
    public Utilisateur findByEmail(@PathVariable String email) {
        return utilisateurService.findByEmail(email);
    }
    @PostMapping("/")
    public int createUser(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.createUser(utilisateur);
    }
    @GetMapping("/Login/Email/{email}/Password/{password}")
    public int loginUser(@PathVariable String email,@PathVariable String password) {
        return utilisateurService.loginUser(email, password);
    }
}
