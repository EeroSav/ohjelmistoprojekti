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
    @JoinTable(
            name="QuestionInSurvey",
            inverseJoinColumns = @JoinColumn(name="surveyId"),
            joinColumns = @JoinColumn(name="questionid")
    )
    Set<Question> surveyquestions = new HashSet<>();

    public Survey(long surveyId, String surveyName) {
        this.surveyId = surveyId;
        this.surveyName = surveyName;
    }

    public Survey() {

    }

    public Set<Question> getSurveyquestions() {
        return surveyquestions;
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
}
