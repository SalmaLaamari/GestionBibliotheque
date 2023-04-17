package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.Reception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReceptionDao extends JpaRepository<Reception,Long> {
    Reception findByReference(String reference);
    List<Reception> deleteByDateReception(LocalDateTime date);
    int deleteByReference(String reference);
}
