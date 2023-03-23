package com.example.demo_back.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AccountJpa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,name="Username")
    private String username;
    @Column(nullable = false,name="Password")
    private String password;

}
