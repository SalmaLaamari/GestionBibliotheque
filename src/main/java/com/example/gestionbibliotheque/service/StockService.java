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
        if (findByReference(stock.getReference())!=null) {
            return -2;
        }else if (stock.getCapacite()==null) {
            return -3;
        }else {
            stockDao.save(stock);
            stock.setReference("Stock-"+stock.getId());
            stockDao.save(stock);
            return 1;
        }

    }

    public int update(Stock stock) {
        Stock stock1 = findByReference(stock.getReference());
        if (stock1 != null) {
            if (stock.getQuantite() != 0) {
                stock1.setQuantite(stock.getQuantite());
            }
            if (stock.getCapacite() != null) {
                stock1.setCapacite(stock.getCapacite());
            }
            stockDao.save(stock1);
            return 1;
        } else {
            stockDao.save(stock);
            return 2;
        }
    }

}
