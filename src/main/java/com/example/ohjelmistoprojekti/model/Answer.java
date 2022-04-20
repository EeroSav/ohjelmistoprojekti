package com.example.ohjelmistoprojekti.model;


import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long answerid;
    private String question, answer;

    @ManyToOne
    @JoinColumn(name = "id")
    private Question questiontitle;

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

    public Question getQuestiontitle() {
        return questiontitle;
    }

    public void setQuestiontitle(Question questiontitle) {
        this.questiontitle = questiontitle;
    }
}