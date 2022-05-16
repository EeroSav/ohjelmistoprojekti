package com.example.ohjelmistoprojekti.question;

class QuestionNotFoundException extends RuntimeException {

    QuestionNotFoundException(Long questionid) {
        super("Could not find question " + questionid);
    }
}