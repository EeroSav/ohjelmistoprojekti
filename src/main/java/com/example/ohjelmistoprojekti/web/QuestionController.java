package com.example.ohjelmistoprojekti.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.ohjelmistoprojekti.model.*;

@Controller
public class QuestionController {

    @RequestMapping(value = "/addQuestion")
    public String addQuestion(Model model) {
        model.addAttribute("question", new Question());

        return "addQuestion";
    }
}
