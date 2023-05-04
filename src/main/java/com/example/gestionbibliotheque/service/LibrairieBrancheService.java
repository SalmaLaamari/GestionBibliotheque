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
        if (librairieBranche.getName()==null ) {
            return -3;
        } else if (librairieBranche.getEmail()==null ) {
            return -4;
        } else if (librairieBranche.getDescription()==null ) {
            return -5;
        }else {
            librairieBrancheDao.save(librairieBranche);
            librairieBranche.setLibrairie(librairieBranche.getLibrairie());
            librairieBranche.setReference("LibrairieBranch-"+librairieBranche.getId());
            librairieBrancheDao.save(librairieBranche);
            return 1;

        }
    }

    public int update(LibrairieBranche librairieBranche){
        LibrairieBranche librairieBranche1 = findByReference(librairieBranche.getReference());
        if (librairieBranche1 != null){
            if (librairieBranche.getName() != null) {
                librairieBranche1.setName(librairieBranche.getName());
            }
            if (librairieBranche.getEmail() != null) {
                librairieBranche1.setEmail(librairieBranche.getEmail());
            }
            if (librairieBranche.getDescription() != null) {
                librairieBranche1.setDescription(librairieBranche.getDescription());
            }
            if (librairieBranche.getLibrairie() != null) {
                librairieBranche1.setLibrairie(librairieBranche.getLibrairie());
            }
            librairieBrancheDao.save(librairieBranche1);
            return 1;
        } else {
            librairieBrancheDao.save(librairieBranche);
            return 2;
        }
    }

}
