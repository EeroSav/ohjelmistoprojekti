package com.example.ohjelmistoprojekti.survey;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
    List<Survey> findBySurveyId(Long surveyId);
}
