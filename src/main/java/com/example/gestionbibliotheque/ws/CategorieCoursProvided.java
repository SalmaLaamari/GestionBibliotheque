package com.example.gestionbibliotheque.ws;

import com.example.gestionbibliotheque.bean.CategorieCours;
import com.example.gestionbibliotheque.service.CategorieCoursService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("GestionBiblio/CategorieCours")
public class CategorieCoursProvided {
    @Autowired
    private CategorieCoursService categorieCoursService;
    @GetMapping("/reference/{reference}")
    public CategorieCours findByReference(@PathVariable String reference) {
        return categorieCoursService.findByReference(reference);
    }

    @GetMapping("/nom/{nom}")
    public CategorieCours findByNom(@PathVariable String nom) {
        return categorieCoursService.findByNom(nom);
    }

    @Transactional
    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return categorieCoursService.deleteByReference(reference);
    }
    @DeleteMapping("/nom/{nom}")
    @Transactional
    public int deleteByNom(@PathVariable String nom) {
        return categorieCoursService.deleteByNom(nom);
    }
    @GetMapping("/")
    public List<CategorieCours> findAll() {
        return categorieCoursService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody CategorieCours categorieCours) {
        return categorieCoursService.save(categorieCours);
    }

    @PutMapping("/")
    public int update(@RequestBody CategorieCours categorieCours) {
        return categorieCoursService.update(categorieCours);
    }
}
