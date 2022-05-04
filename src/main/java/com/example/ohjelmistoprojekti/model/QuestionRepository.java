package com.example.ohjelmistoprojekti.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByTitle(String title);
    List<Question> findByQuestionid(Long questionid);
}
