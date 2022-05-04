package com.example.ohjelmistoprojekti.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long>{

    List<Answer> findByInput(String input);
    List<Answer> findAll();
     //List<Answer> findByQuestionid(Long questionid);

}
