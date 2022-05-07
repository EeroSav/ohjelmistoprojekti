package com.example.ohjelmistoprojekti.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByUserid(Long userid);
    List<User> findAll();
}