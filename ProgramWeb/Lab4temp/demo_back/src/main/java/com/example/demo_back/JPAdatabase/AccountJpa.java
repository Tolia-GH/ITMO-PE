package com.example.demo_back.JPAdatabase;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "account_jpa")
public class AccountJpa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,name="Username")
    private String username;
    @Column(nullable = false,name="Password")
    private String password;
}
