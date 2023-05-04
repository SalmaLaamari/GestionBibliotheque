package com.example.gestionbibliotheque.ws;

import com.example.gestionbibliotheque.bean.CategorieLivre;
import com.example.gestionbibliotheque.service.CategorieLivreService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("GestionBiblio/CategorieLivre")
public class CategorieLivreProvided {
    @Autowired
    private CategorieLivreService categorieLivreService;

    @GetMapping("/reference/{reference}")
    public CategorieLivre findByReference(@PathVariable String reference) {
        return categorieLivreService.findByReference(reference);
    }

    @GetMapping("/nom/{nom}")
    public CategorieLivre findByNom(@PathVariable String nom) {
        return categorieLivreService.findByNom(nom);
    }

    @Transactional
    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return categorieLivreService.deleteByReference(reference);
    }

    @Transactional
    @DeleteMapping("/nom/{nom}")
    public int deleteByNom(@PathVariable String nom) {
        return categorieLivreService.deleteByNom(nom);
    }

    @GetMapping("/")
    public List<CategorieLivre> findAll() {
        return categorieLivreService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody CategorieLivre categorieLivre) {
        return categorieLivreService.save(categorieLivre);
    }

    @PutMapping("/")
    public int update(@RequestBody CategorieLivre categorieLivre) {
        return categorieLivreService.update(categorieLivre);
    }
}
