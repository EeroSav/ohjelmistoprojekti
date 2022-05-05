package com.example.ohjelmistoprojekti.web;

import com.example.ohjelmistoprojekti.model.AnswerRepository;
import com.example.ohjelmistoprojekti.model.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//Etusivun oma controller
@Controller
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;


    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value={"/list"})
    public String questions(Model model) {
        model.addAttribute("questions", questionRepository.findAll());
        return "questions";
    }
}
