package com.example.ohjelmistoprojekti.answer;

import com.example.ohjelmistoprojekti.question.Question;
import com.example.ohjelmistoprojekti.user.User;

import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long answerid;
    private String input;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "questionid")
    private Question question;

    /*
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid")
    private User user;
    */

    public Answer(){
        super();
        this.input = "";
    }

    public Answer(String input, Question question){
        super();
        this.input = input;
        this.question = question;
    }

    public Answer(String input){
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

    public void setInput(String input) {
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