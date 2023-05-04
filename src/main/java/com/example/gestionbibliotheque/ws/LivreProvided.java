package com.example.gestionbibliotheque.ws;

import com.example.gestionbibliotheque.bean.Livre;
import com.example.gestionbibliotheque.service.LivreService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public List<Livre> findByAuteur(@PathVariable String auteur) {
        return livreService.findByAuteur(auteur);
    }

    @GetMapping("/Titre/{titre}")
    public Optional<Livre> findByTitre(@PathVariable String titre) {
        return livreService.findByTitre(titre);
    }
    @PostMapping("/")
    public void save(@RequestBody Livre livre) {
        livreService.save(livre);
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

    @GetMapping("/langue/{langue}")
    public List<Livre> findByLangue(@PathVariable String langue) {
        return livreService.findByLangue(langue);
    }

    @GetMapping("/nom/{nom}")
    public List<Livre> findByCategorieLivreNom(@PathVariable String nom) {
        return livreService.findByCategorieLivreNom(nom);
    }

    @DeleteMapping("/titre/{titre}")
    @Transactional
    public void removeOneCopy(@PathVariable String titre) {
        livreService.removeOneCopy(titre);
    }
    @GetMapping("/")
    public List<Livre> findAll() {
        return livreService.findAll();
    }

    @PutMapping("/")
    public int update(@RequestBody Livre livre) {
        return livreService.update(livre);
    }

    @Transactional
    @DeleteMapping("/ID/{id}")
    public void deleteById(@PathVariable Long id) {
        livreService.deleteById(id);
    }
}
