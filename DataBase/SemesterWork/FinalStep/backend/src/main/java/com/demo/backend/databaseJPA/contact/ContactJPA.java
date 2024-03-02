package com.demo.backend.databaseJPA.contact;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contact", schema = "smart_home")
public class ContactJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name="user_id")
    private Integer user_id;
    @Column(nullable = false,name="email")
    private String email;
    @Column(nullable = false,name="phone_num")
    private String phone_num;
}
