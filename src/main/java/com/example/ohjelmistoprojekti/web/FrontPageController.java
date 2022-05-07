package com.example.ohjelmistoprojekti.web;

import com.example.ohjelmistoprojekti.answer.AnswerRepository;
import com.example.ohjelmistoprojekti.question.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//Etusivun oma controller
@Controller
public class FrontPageController {
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
