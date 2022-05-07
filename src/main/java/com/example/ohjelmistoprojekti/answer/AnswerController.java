package com.example.ohjelmistoprojekti.answer;

import com.example.ohjelmistoprojekti.question.Question;
import com.example.ohjelmistoprojekti.question.QuestionRepository;
import com.example.ohjelmistoprojekti.user.User;
import com.example.ohjelmistoprojekti.user.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerController {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    AnswerController(AnswerRepository answerRepository, QuestionRepository questionRepository, UserRepository userRepository){
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    //Yhdistä kysymys vastaukseen
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

    //Yhdistä käyttäjä vastaukseen
    @PutMapping("/answers/{answerid}/users/{userid}")
    Answer assignUserToAnswer(
            @PathVariable Long answerid,
            @PathVariable Long userid
    ) {
        Answer answer = answerRepository.findByAnswerid(answerid);
        User user = userRepository.findByUserid(userid);
        answer.setUser(user);
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

    //Poista vastaus
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/answers/{id}")
    void deleteAnswer(@PathVariable Long id) {
        answerRepository.deleteById(id);
    }
}
