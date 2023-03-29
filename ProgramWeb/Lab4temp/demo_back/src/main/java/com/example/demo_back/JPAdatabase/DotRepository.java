package com.example.demo_back.JPAdatabase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DotRepository extends JpaRepository<DotJpa,Integer> {
    @Query(value = "select * from dot_jpa where owner=?1",nativeQuery = true)
    List<DotJpa> getAllByOwner(String owner);
}
