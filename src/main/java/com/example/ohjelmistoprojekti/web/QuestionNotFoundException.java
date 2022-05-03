package com.example.ohjelmistoprojekti.web;

class QuestionNotFoundException extends RuntimeException {

    QuestionNotFoundException(Long questionid) {
        super("Could not find employee " + questionid);
    }
}