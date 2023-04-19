package com.example.gestionbibliotheque.service;

import com.example.gestionbibliotheque.bean.Reception;
import com.example.gestionbibliotheque.dao.ReceptionDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReceptionService {
    @Autowired
    private ReceptionDao receptionDao;

    public Reception findByReference(String reference) {
        return receptionDao.findByReference(reference);
    }

    public List<Reception> findByDateReception(LocalDateTime date) {
        return receptionDao.findByDateReception(date);
    }
    @Transactional
    public int deleteByReference(String reference) {
        return receptionDao.deleteByReference(reference);
    }
    public List<Reception> findAll() {
        return receptionDao.findAll();
    }
    public int save(Reception reception){
        if (reception.getReference()==null){
            return -1;
        } else if (findByReference(reception.getReference())!=null) {
            return -2;
        }else {
            reception.setReference("Reception-"+reception.getId());
            LocalDateTime localDateTime= LocalDateTime.now();
            reception.setDateReception(localDateTime);
            receptionDao.save(reception);
            return 1;

        }
    }
}
