package com.example.ohjelmistoprojekti.web;

class AnswerNotFoundException extends RuntimeException{

    AnswerNotFoundException(Long answerid) { super("could not find answer" + answerid);}
}
