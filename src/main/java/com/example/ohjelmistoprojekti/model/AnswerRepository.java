package com.example.ohjelmistoprojekti.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswerRepository extends CrudRepository<Answer, Long>{

    List<Answer> findByName(String answer);

}
