package com.example.ohjelmistoprojekti.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.ohjelmistoprojekti.model.*;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QuestionController {

    @Autowired
    private questionRepository qRepository;


    @RequestMapping("/questions")
    public String index(Model model) {
        model.addAttribute("questions", qRepository.findAll());
        return "questions";
    }

    @RequestMapping(value = "/addquestion")
    public String addQuestion(Model model) {
        model.addAttribute("question", new Question());

        return "addquestion";
    }

    @RequestMapping(value = "/savequestion", method = RequestMethod.POST)
    public String saveQuestion(Question question) {
        qRepository.save(question);
        return "redirect:/questions";
    }
}
