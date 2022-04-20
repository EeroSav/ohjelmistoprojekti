package com.example.ohjelmistoprojekti.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long answerid;
    private String input;

    @ManyToOne
    @JoinColumn(name = "questionid")
    private Question question;

    public Answer(){
        super();
        this.input = "";
    }

    public Answer(String input, Question question){
        super();
        this.input = input;
        this.question = question;
    }

    public Answer(String answer){
        super();
        this.input = input;
    }

    public long getAnswerid() {
        return answerid;
    }

    public void setAnswerid(long answerid) {
        this.answerid = answerid;
    }

    public String getInput() {
        return input;
    }

    public void setnput(String input) {
        this.input = input;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerid=" + answerid +
                ", input='" + input + '\'' +
                ", question=" + question +
                '}';
    }
}