package com.example.ohjelmistoprojekti.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long questionid;
    private String title;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private List<Answer> answerList;

    public Question(){
        super();
        this.title = "";
    }

    public Question(String title){
        super();
        this.title = title;
    }

    public long getQuestionid() {
        return questionid;
    }

    public void setQuestionid(long questionid) {
        this.questionid = questionid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionid=" + questionid +
                ", title='" + title + '\'' +
                ", answerList=" + answerList +
                '}';
    }
}
