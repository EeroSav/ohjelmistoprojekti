package com.example.ohjelmistoprojekti.answer;

import com.example.ohjelmistoprojekti.question.Question;
import com.example.ohjelmistoprojekti.question.QuestionRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerController {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    AnswerController(AnswerRepository answerRepository, QuestionRepository questionRepository){
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    @PutMapping("/answers/{answerid}/questions/{questionid}")
    Answer assignAnswerToQuestion(
            @PathVariable Long answerid,
            @PathVariable Long questionid
    ) {
        Answer answer = answerRepository.findByAnswerid(answerid);
        Question question = questionRepository.findByQuestionid(questionid);
        answer.setQuestion(question);
        return answerRepository.save(answer);
    }

    //Hae kaikki vastaukset
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/answers")
    List<Answer> allanswers() {
        return answerRepository.findAll();
    }

    //Tee uusi vastaus
    @PostMapping("/answers")
    Answer newAnswer(@RequestBody Answer newAnswer) {
        return answerRepository.save(newAnswer);
    }

    //Hae vastaus id:llä
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/answers/{id}")
    Answer oneA(@PathVariable Long id) {
        return answerRepository.findById(id)
                .orElseThrow(() -> new AnswerNotFoundException(id));
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
    @DeleteMapping("/answers/{id}")
    void deleteAnswer(@PathVariable Long id) {
        answerRepository.deleteById(id);
    }
}
