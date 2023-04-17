package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.bean.LibrairieBranche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrairieBrancheDao extends JpaRepository<LibrairieBranche,Long> {
    LibrairieBranche findByReference(String reference);
    LibrairieBranche findByName(String name);
    List<LibrairieBranche> findByLibrairieReference(String reference);
    int deleteByReference(String reference);
}
