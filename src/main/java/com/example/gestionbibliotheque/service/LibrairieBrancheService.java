package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.LibrairieBranche;
import com.example.gestionbibliotheque.dao.LibrairieBrancheDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrairieBrancheService {
    @Autowired
    private LibrairieBrancheDao librairieBrancheDao;

    public LibrairieBranche findByReference(String reference) {
        return librairieBrancheDao.findByReference(reference);
    }

    public LibrairieBranche findByName(String name) {
        return librairieBrancheDao.findByName(name);
    }

    public List<LibrairieBranche> findByLibrairieReference(String reference) {
        return librairieBrancheDao.findByLibrairieReference(reference);
    }
    @Transactional
    public int deleteByReference(String reference) {
        return librairieBrancheDao.deleteByReference(reference);
    }

    public List<LibrairieBranche> findAll() {
        return librairieBrancheDao.findAll();
    }
    public  int save(LibrairieBranche librairieBranche){
        if (librairieBranche.getReference()==null){
            return -1;
        } else if (findByReference(librairieBranche.getReference())!=null) {
            return -2;
        } else if (librairieBranche.getName()==null ) {
            return -3;
        }else {
            librairieBranche.setLibrairie(librairieBranche.getLibrairie());
            librairieBranche.setReference("LibrairieBranch-"+librairieBranche.getId());
            librairieBrancheDao.save(librairieBranche);
            return 1;

        }
    }
}
