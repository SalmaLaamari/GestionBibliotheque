package com.example.gestionbibliotheque.ws;

import com.example.gestionbibliotheque.bean.FournisseurLivre;
import com.example.gestionbibliotheque.service.FournisseurLivreService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("GestionBiblio/FournisseurLivre")
public class FournisseurLivreProvided {
    @Autowired
    private FournisseurLivreService fournisseurLivreService;
    @GetMapping("/reference/{reference}")
    public FournisseurLivre findByReference(@PathVariable String reference) {
        return fournisseurLivreService.findByReference(reference);
    }
    @GetMapping("/nom/{nom}")
    public FournisseurLivre findByNom(@PathVariable String nom) {
        return fournisseurLivreService.findByNom(nom);
    }
    @GetMapping("/prenom/{prenom}")
    public FournisseurLivre findByPrenom(@PathVariable String prenom) {
        return fournisseurLivreService.findByPrenom(prenom);
    }
    @GetMapping("/email/{email}")
    public FournisseurLivre findByEmail(@PathVariable String email) {
        return fournisseurLivreService.findByEmail(email);
    }
    @GetMapping("/adresse/{adresse}")
    public FournisseurLivre findByAdresse(@PathVariable String adresse) {
        return fournisseurLivreService.findByAdresse(adresse);
    }
    @GetMapping("/telephone/{telephone}")
    public FournisseurLivre findByTelephone(@PathVariable String telephone) {
        return fournisseurLivreService.findByTelephone(telephone);
    }
    @Transactional
    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return fournisseurLivreService.deleteByReference(reference);
    }
    @GetMapping("/")
    public List<FournisseurLivre> findAll() {
        return fournisseurLivreService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody FournisseurLivre fournisseurLivre) {
        return fournisseurLivreService.save(fournisseurLivre);
    }

    @PutMapping("/")
    public int update(@RequestBody FournisseurLivre fournisseurLivre) {
        return fournisseurLivreService.update(fournisseurLivre);
    }

}
