package com.example.ohjelmistoprojekti.survey;

import com.example.ohjelmistoprojekti.question.Question;
import com.example.ohjelmistoprojekti.question.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SurveyController {

    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    QuestionRepository questionRepository;

    @PostMapping("/surveys")
    Survey newSurvey(@RequestBody Survey newSurvey){
        return surveyRepository.save(newSurvey);
    }

    @GetMapping("/surveys")
    List<Survey> allSurveys(){
        return surveyRepository.findAll();
    }

    //Yhdistä kysymys kyselyyn
    @PutMapping("/survey/{surveyId}/questions/{questionid}")
    Survey addQuestiontoSurvey(
            @PathVariable Long surveyId,
            @PathVariable Long questionid
    ) {
        Survey survey = surveyRepository.findBySurveyId(surveyId);
        Question question = questionRepository.findByQuestionid(questionid);
        survey.surveyquestions.add(question);
        return surveyRepository.save(survey);
    }


}
