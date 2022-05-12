package com.example.ohjelmistoprojekti.survey;


import com.example.ohjelmistoprojekti.question.Question;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long surveyId;
    private String surveyName;

    @ManyToMany
    private Set<Question> questions = new HashSet<>();

    public Survey() {
    }

    public Survey(long surveyId, String surveyName, Set<Question> questions) {
        this.surveyId = surveyId;
        this.surveyName = surveyName;
        this.questions = questions;
    }

    public long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(long surveyId) {
        this.surveyId = surveyId;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
