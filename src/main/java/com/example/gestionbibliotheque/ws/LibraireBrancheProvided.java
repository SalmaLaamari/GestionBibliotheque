package com.example.gestionbibliotheque.ws;

import com.example.gestionbibliotheque.bean.LibrairieBranche;
import com.example.gestionbibliotheque.service.LibrairieBrancheService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("GestionBiblio/LibraireBranche")
public class LibraireBrancheProvided {
    @Autowired
    private LibrairieBrancheService librairieBrancheService;
    @GetMapping("/reference/{reference}")
    public LibrairieBranche findByReference(@PathVariable String reference) {
        return librairieBrancheService.findByReference(reference);
    }
    @GetMapping("/name/{name}")
    public LibrairieBranche findByName(@PathVariable String name) {
        return librairieBrancheService.findByName(name);
    }
    @GetMapping("/LibraireReference/{reference}")
    public List<LibrairieBranche> findByLibrairieReference(@PathVariable String reference) {
        return librairieBrancheService.findByLibrairieReference(reference);
    }

    @Transactional
    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return librairieBrancheService.deleteByReference(reference);
    }
    @GetMapping("/")
    public List<LibrairieBranche> findAll() {
        return librairieBrancheService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody LibrairieBranche librairieBranche) {
        return librairieBrancheService.save(librairieBranche);
    }
}
