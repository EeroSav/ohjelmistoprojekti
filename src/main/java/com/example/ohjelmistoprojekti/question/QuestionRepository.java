package com.example.ohjelmistoprojekti.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByTitle(String title);
    Question findByQuestionid(Long questionid);
}
