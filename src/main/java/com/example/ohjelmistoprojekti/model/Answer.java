package com.example.ohjelmistoprojekti.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long answerid;
    private String question, answer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "answer")
    private List<Question> questions;

    public Answer() {
        super();
        this.answer = "";
    }

    public Answer(String answer) {
        super();
        this.answer = answer;
    }

    public Answer(String question, String answer) {
        super();
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}