package com.example.ohjelmistoprojekti.answer;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class AnswerNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(AnswerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String answerNotFoundHandler(AnswerNotFoundException ex) {
        return ex.getMessage();
    }
}
