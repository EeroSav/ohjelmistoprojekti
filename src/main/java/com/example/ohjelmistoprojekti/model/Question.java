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
    @ManyToOne
    @JoinColumn(name = "answerid")
    private Answer answer;



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

    @Override
    public String toString() {
        return "Kysymys{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
