package com.example.ohjelmistoprojekti;

import com.example.ohjelmistoprojekti.model.Answer;
import com.example.ohjelmistoprojekti.model.AnswerRepository;
import com.example.ohjelmistoprojekti.model.Question;
import com.example.ohjelmistoprojekti.model.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OhjelmistoprojektiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OhjelmistoprojektiApplication.class, args);
	}
}
