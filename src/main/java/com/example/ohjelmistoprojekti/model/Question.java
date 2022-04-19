package com.example.ohjelmistoprojekti.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String title;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private List<Answer> answersList;

    public Question(){
        super();
        this.title="";
    }


    public Question(String title) {
        super();
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Answer> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<Answer> answersList) {
        this.answersList = answersList;
    }

    @Override
    public String toString() {
        return "Kysymys{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
