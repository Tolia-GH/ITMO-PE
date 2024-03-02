package com.demo.backend.databaseJPA.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserJPA, Integer> {
    @Query(value = "select max(id) from UserJPA")
    List<Integer> findLatestUserId();

    @Query(value="select A from UserJPA A where A.contactJPA.email = ?1 ")
    List<UserJPA> findUserJpaByEmail(String email);

    @Query(value="select A from UserJPA A where A.contactJPA.phone_num = ?1 ")
    List<UserJPA> findUserJpaByPhone(String phone);

    @Query(value="select A from UserJPA A where A.id = ?1 ")
    List<UserJPA> findUserJpaById(Integer id);

}
