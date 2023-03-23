package com.example.demo_back.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="DotJpa")
public class DotJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,name="X")
    private Double x;
    @Column(nullable = false,name="Y")
    private Double y;
    @Column(nullable = false,name="R")
    private Integer r;
    @Column(nullable = false,name="Hit")
    private Boolean hit;
    @Column(nullable = false,name = "Date")
    private String date;
}
