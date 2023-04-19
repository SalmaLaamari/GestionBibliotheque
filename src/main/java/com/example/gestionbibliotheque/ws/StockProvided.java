package com.example.gestionbibliotheque.ws;

import com.example.gestionbibliotheque.bean.Stock;
import com.example.gestionbibliotheque.service.StockService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("GestionBiblio/Stock")
public class StockProvided {
    @Autowired
    private StockService stockService;
    @GetMapping("/Reference/{reference}")
    public Stock findByReference(@PathVariable String reference) {
        return stockService.findByReference(reference);
    }
    @DeleteMapping("/Reference/{reference}")
    @Transactional
    public int deleteByReference(@PathVariable String reference) {
        return stockService.deleteByReference(reference);
    }
    @GetMapping("/")
    public List<Stock> findAll() {
        return stockService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Stock stock) {
        return stockService.save(stock);
    }
}
