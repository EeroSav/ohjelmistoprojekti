package com.example.ohjelmistoprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.ohjelmistoprojekti.model.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@RestController
public class QuestionController {

    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    @Autowired
    public QuestionController(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getQuestions() {
        return ResponseEntity.ok(questionRepository.findAll());
    }
    public ResponseEntity<List<Answer>> getAnswers() {
        return ResponseEntity.ok(answerRepository.findAll());
    }

}





/*    @RequestMapping("/questions")
    public questions(@RequestParam) {
        Answer answer = new Answer();
        model.addAttribute("answer", new Answer());
        model.addAttribute("questions", qrepository.findAll());
        return "questions";
    }

    @RequestMapping(value = "/addquestion")
    public String addQuestion(Model model) {
        model.addAttribute("question", new Question());
        return "addquestion";
    }

    @RequestMapping(value = "/savequestion", method = RequestMethod.POST)
    public String saveQuestion(Question question) {
        qrepository.save(question);
        return "redirect:/questions";
    }

        //REST haku kaikille kysymyksille
    @RequestMapping(value="/allQuestions")
    public @ResponseBody List<Question> questionListRest() {
        return (List<Question>) qrepository.findAll();
    }

        //REST haku kaikille vastauksille
    @RequestMapping(value="/allAnswers")
    public @ResponseBody List<Answer> answerListRest(){
        return (List<Answer>) arepository.findAll();
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String saveAnswer(Answer answer){
        arepository.save(answer);
        return "redirect:questions";
    }
}
*/