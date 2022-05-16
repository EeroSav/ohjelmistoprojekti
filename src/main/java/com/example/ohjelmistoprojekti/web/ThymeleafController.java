package com.example.ohjelmistoprojekti.web;

import com.example.ohjelmistoprojekti.answer.AnswerRepository;
import com.example.ohjelmistoprojekti.question.Question;
import com.example.ohjelmistoprojekti.question.QuestionRepository;
import com.example.ohjelmistoprojekti.survey.Survey;
import com.example.ohjelmistoprojekti.survey.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


//Etusivun oma controller
@Controller
public class ThymeleafController {



    @Autowired
    private SurveyRepository sRepository;

    @Autowired
    private QuestionRepository qRepository;

    @Autowired
    private AnswerRepository answerRepository;



    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/list")
    public String allSurveys(Model model) {
        model.addAttribute("surveys", sRepository.findAll());
        model.addAttribute("questions", qRepository.findAll());
        return "questions";
    }

    @RequestMapping(value = "/add")
    public String addSurvey(Model model) {
        model.addAttribute("survey", new Survey());
        model.addAttribute("question", new Question());
        return "addquestion";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSurvey(@ModelAttribute Survey survey, BindingResult bindingResult) {
        sRepository.save(survey);
        return "redirect:list";
    }


}
