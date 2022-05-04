package com.example.ohjelmistoprojekti.web;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.ohjelmistoprojekti.model.*;

import java.util.List;
import java.util.Map;

@RestController
public class RestQuestionController {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    RestQuestionController(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    //Hae kaikki kysymykset
    @GetMapping("/questions")
    List<Question> allquestions() {
        return questionRepository.findAll();
    }

    //Hae kaikki vastaukset
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/answers")
    List<Answer> allanswers() {
        return answerRepository.findAll();
    }

    //Tee uusi kysymys
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/questions")
    Question newQuestion(@RequestBody Question newQuestion) {
        return questionRepository.save(newQuestion);
    }

    //Tee uusi vastaus
    @PostMapping("/answers")
    Answer newAnswer(@RequestBody Answer newAnswer) {
        return answerRepository.save(newAnswer);
    }

    //Hae kysymys id:llä
    @GetMapping("/questions/{id}")
    Question oneQ(@PathVariable Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException(id));
    }

    //Hae vastaus id:llä
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/answers/{id}")
    Answer oneA(@PathVariable Long id) {
        return answerRepository.findById(id)
                .orElseThrow(() -> new AnswerNotFoundException(id));
    }

    /*Hae vastaus kysymysid:llä

    @GetMapping("/answersbyquestion/{id}")
    List<Answer> answersByQuestion(@PathVariable Long id) {
        return answerRepository.findByQuestionid(id);
    }

    */

    //Kysymysten editoimiseen
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/questions/{id}")
    Question replaceQuestion(@RequestBody Question newQuestion, @PathVariable Long id) {
        return questionRepository.findById(id)
                .map(question -> {
                    question.setTitle(newQuestion.getTitle());
                    return questionRepository.save(question);
        })
                .orElseGet(() -> {
                    newQuestion.setQuestionid(id);
                    return questionRepository.save(newQuestion);
                });
    }


    //Vastausten editoimiseen
    @PutMapping("/answers/{id}")
    Answer replaceAnswer(@RequestBody Answer newAnswer, @PathVariable Long id) {
        return answerRepository.findById(id)
                .map(answer -> {
                    answer.setInput(newAnswer.getInput());
                    answer.setQuestion(newAnswer.getQuestion());
                    return answerRepository.save(answer);
        })
                .orElseGet(() -> {
                    newAnswer.setAnswerid(id);
                    return answerRepository.save(newAnswer);
        });
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/questions/{id}")
    void deleteQuestion(@PathVariable Long id) {
        questionRepository.deleteById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/answers/{id}")
    void deleteAnswer(@PathVariable Long id) {
        answerRepository.deleteById(id);
    }
}
