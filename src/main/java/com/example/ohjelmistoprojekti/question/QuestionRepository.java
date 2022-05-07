package com.example.ohjelmistoprojekti.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByTitle(String title);
    Question findByQuestionid(Long questionid);
}
