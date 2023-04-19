package com.example.gestionbibliotheque.ws;

import com.example.gestionbibliotheque.bean.Reception;
import com.example.gestionbibliotheque.service.ReceptionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("GestionBiblio/Reception")
public class ReceptionProvided {
    @Autowired
    private ReceptionService receptionService;
    @GetMapping("/reference/{reference}")
    public Reception findByReference(@PathVariable String reference) {
        return receptionService.findByReference(reference);
    }
    @GetMapping("/DateReception/{date}")
    public List<Reception> findByDateReception(@PathVariable LocalDateTime date) {
        return receptionService.findByDateReception(date);
    }
    @DeleteMapping("/Reception/{reference}")
    @Transactional
    public int deleteByReference(@PathVariable String reference) {
        return receptionService.deleteByReference(reference);
    }
    @GetMapping("/")
    public List<Reception> findAll() {
        return receptionService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Reception reception) {
        return receptionService.save(reception);
    }
    }
