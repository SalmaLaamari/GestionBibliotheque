package com.example.gestionbibliotheque.ws;

import com.example.gestionbibliotheque.bean.Livre;
import com.example.gestionbibliotheque.service.LivreService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("GestionBiblio/Livre")
public class LivreProvided {
    @Autowired
    private LivreService livreService;
    @GetMapping("/LivreReference/{reference}")
    public Livre findByReference(@PathVariable String reference) {
        return livreService.findByReference(reference);
    }
    @GetMapping("/Auteur/{auteur}")
    public Livre findByAuteur(@PathVariable String auteur) {
        return livreService.findByAuteur(auteur);
    }
    @GetMapping("/Titre/{titre}")
    public Livre findByTitre(@PathVariable String titre) {
        return livreService.findByTitre(titre);
    }
    @GetMapping("/categorie/{categorie}")
    public List<Livre> findByCategorie(@PathVariable String categorie) {
        return livreService.findByCategorie(categorie);
    }

    @GetMapping("/FournisseurLivreReference/{reference}")
    public List<Livre> findByFournisseurLivreReference(@PathVariable String reference) {
        return livreService.findByFournisseurLivreReference(reference);
    }
    @GetMapping("/StockReference/{reference}")
    public List<Livre> findByStockReference(@PathVariable String reference) {
        return livreService.findByStockReference(reference);
    }
    @GetMapping("/DatePublication/{date}")
    public List<Livre> findByDatePublication(@PathVariable LocalDateTime date) {
        return livreService.findByDatePublication(date);
    }
    @DeleteMapping("/Reference/{reference}")
    @Transactional
    public int deleteByReference(@PathVariable String reference) {
        return livreService.deleteByReference(reference);
    }
    @GetMapping("/")
    public List<Livre> findAll() {
        return livreService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Livre livre) {
        return livreService.save(livre);
    }

    @PutMapping("/")
    public int update(@RequestBody Livre livre) {
        return livreService.update(livre);
    }
}
