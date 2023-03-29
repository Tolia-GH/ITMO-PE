package com.example.demo_back.service;

import com.example.demo_back.JPAdatabase.DotJpa;
import com.example.demo_back.JPAdatabase.DotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DotService {
    @Autowired
    DotRepository dotRepository;

    public void addDot(String owner, Double x, Double y,Integer r,Boolean hit,String date){
        DotJpa dotJpa = new DotJpa();
        dotJpa.setOwner(owner);
        dotJpa.setX(x);
        dotJpa.setY(y);
        dotJpa.setR(r);
        dotJpa.setHit(hit);
        dotJpa.setDate(date);
        dotRepository.save(dotJpa);
    }

    public List<DotJpa> findAllByOwner(String owner) {
        return dotRepository.getAllByOwner(owner);
    }
}
