package com.example.demo_back.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountJpa,Integer> {
    @Query(value="select * from account_jpa where username = ?1",nativeQuery = true)
    List<AccountJpa> findByUsername(String name);
}
