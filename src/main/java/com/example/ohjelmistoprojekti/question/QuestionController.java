package com.example.ohjelmistoprojekti.question;


import com.example.ohjelmistoprojekti.answer.Answer;
import com.example.ohjelmistoprojekti.answer.AnswerController;
import com.example.ohjelmistoprojekti.answer.AnswerRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    private final QuestionRepository questionRepository;

    QuestionController(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    //Hae kaikki kysymykset
    @GetMapping("/questions")
    List<Question> allquestions() {
        return questionRepository.findAll();
    }

    //Tee uusi kysymys
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/questions")
    Question newQuestion(@RequestBody Question newQuestion) {
        return questionRepository.save(newQuestion);
    }

    //Hae kysymys id:llä
    @GetMapping("/questions/{id}")
    Question oneQ(@PathVariable Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException(id));
    }

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

    //Poista kysymys
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/questions/{id}")
    void deleteQuestion(@PathVariable Long id) {
        questionRepository.deleteById(id);
    }
}
