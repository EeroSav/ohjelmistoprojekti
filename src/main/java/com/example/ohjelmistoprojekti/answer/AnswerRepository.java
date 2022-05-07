package com.example.ohjelmistoprojekti.answer;

import com.example.ohjelmistoprojekti.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long>{

    List<Answer> findByInput(String input);
    List<Answer> findAll();
    Answer findByAnswerid(Long answerid);
     //List<Answer> findByQuestionid(Long questionid);

}
