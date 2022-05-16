package com.example.ohjelmistoprojekti.question;

import com.example.ohjelmistoprojekti.answer.Answer;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long questionid;
    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "question")
    private List<Answer> answerList;

    @JsonIgnore
    @ManyToMany
    private Set<Question> questions = new HashSet<>();


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
    public int hashCode(){
        return Objects.hash(this.questionid, this.title);
    }

    @Override
    public boolean equals (Object o) {
        if(this == o)
            return true;
        if (!(o instanceof Question))
            return false;
        Question question = (Question) o;
        return Objects.equals(this.questionid, question.questionid) &&
                Objects.equals(this.title, question.title);
    }
}
