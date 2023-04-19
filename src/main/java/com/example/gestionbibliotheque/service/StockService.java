package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.Stock;
import com.example.gestionbibliotheque.dao.StockDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockDao stockDao;

    public Stock findByReference(String reference) {
        return stockDao.findByReference(reference);
    }
@Transactional
    public int deleteByReference(String reference) {
        return stockDao.deleteByReference(reference);
    }

    public List<Stock> findAll() {
        return stockDao.findAll();
    }
    public int save(Stock stock){
        if (stock.getReference()==null){
            return -1;
        } else if (findByReference(stock.getReference())!=null) {
            return -2;
        }else if (stock.getCapacite()==null) {
            return -3;
        }else {
            stock.setReference("Stock-"+stock.getId());
            stockDao.save(stock);
            return 1;
        }

    }
}
