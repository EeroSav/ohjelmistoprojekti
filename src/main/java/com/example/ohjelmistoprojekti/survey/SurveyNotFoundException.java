package com.example.ohjelmistoprojekti.survey;

public class SurveyNotFoundException extends RuntimeException {

    SurveyNotFoundException(Long surveyId) {
        super("Could not find survey " + surveyId);
    }
}
