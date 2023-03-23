package com.example.demo_back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DotRepository extends JpaRepository<DotJpa,Integer> {
}
