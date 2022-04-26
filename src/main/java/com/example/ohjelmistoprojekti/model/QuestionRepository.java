package com.example.ohjelmistoprojekti.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {

    List<Question> findByTitle(String title);
    List<Question> findAll();
}
