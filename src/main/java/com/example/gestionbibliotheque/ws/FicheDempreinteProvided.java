package com.example.gestionbibliotheque.ws;

import com.example.gestionbibliotheque.bean.FicheEmpreinte;
import com.example.gestionbibliotheque.service.FicheDempreinteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("GestionBiblio/FicheEmpreinte")
public class FicheDempreinteProvided {
    @Autowired
    private FicheDempreinteService ficheDempreinteService;
   @GetMapping("/reference/{reference}")
    public FicheEmpreinte findByReference(@PathVariable String reference) {
        return ficheDempreinteService.findByReference(reference);
    }

    @GetMapping("/UtilisateurReference/{reference}")
    public List<FicheEmpreinte> findByUtilisateurReference(@PathVariable String reference) {
        return ficheDempreinteService.findByUtilisateurReference(reference);
    }

    @GetMapping("/date/{date}")
    public FicheEmpreinte findByDateRetour(@PathVariable LocalDateTime date) {
        return ficheDempreinteService.findByDateRetour(date);
    }

    @Transactional
    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return ficheDempreinteService.deleteByReference(reference);
    }
    @GetMapping("/")
    public List<FicheEmpreinte> findAll() {
        return ficheDempreinteService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody FicheEmpreinte ficheEmpreinte) {
        return ficheDempreinteService.save(ficheEmpreinte);
    }

    @PutMapping("/")
    public int update(@RequestBody FicheEmpreinte ficheEmpreinte) {
        return ficheDempreinteService.update(ficheEmpreinte);
    }
}
