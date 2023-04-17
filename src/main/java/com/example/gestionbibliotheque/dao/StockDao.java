package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDao extends JpaRepository<Stock,Long> {
    Stock findByReference(String reference);
    int deleteByReference(String reference);
}
