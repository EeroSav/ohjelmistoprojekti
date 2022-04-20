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
    private String answer;

    @ManyToOne
    @JoinColumn(name = "questionid")
    private Question question;

    public Answer(){
        super();
        this.answer = "";
    }

    public Answer(String answer, Question question){
        super();
        this.answer = answer;
        this.question = question;
    }

    public Answer(String answer){
        super();
        this.answer = answer;
    }

    public long getAnswerid() {
        return answerid;
    }

    public void setAnswerid(long answerid) {
        this.answerid = answerid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
                ", answer='" + answer + '\'' +
                ", question=" + question +
                '}';
    }
}