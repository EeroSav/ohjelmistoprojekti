package com.example.ohjelmistoprojekti.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface questionRepository extends CrudRepository {
    List<Question> findByTitle(String title);
}
