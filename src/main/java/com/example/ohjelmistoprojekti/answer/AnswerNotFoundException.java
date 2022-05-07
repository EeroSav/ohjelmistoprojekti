package com.example.ohjelmistoprojekti.answer;

class AnswerNotFoundException extends RuntimeException{

    AnswerNotFoundException(Long answerid) { super("could not find answer" + answerid);}
}
