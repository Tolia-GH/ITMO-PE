package com.example.demo_back.service;

import com.example.demo_back.dao.DotJpa;
import com.example.demo_back.dao.DotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DotService {
    @Autowired
    DotRepository dotRepository;

    public void addDot(Double x, Double y,Integer r,Boolean hit,String date){
        DotJpa dotJpa = new DotJpa();
        dotJpa.setX(x);
        dotJpa.setY(y);
        dotJpa.setR(r);
        dotJpa.setHit(hit);
        dotJpa.setDate(date);
        dotRepository.save(dotJpa);
    }
}
