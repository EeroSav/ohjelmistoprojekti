package com.example.ohjelmistoprojekti;

import com.example.ohjelmistoprojekti.model.Question;
import com.example.ohjelmistoprojekti.model.questionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import main.css;

@SpringBootApplication
public class OhjelmistoprojektiApplication {
	private static final Logger log = LoggerFactory.getLogger(OhjelmistoprojektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OhjelmistoprojektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner questionDemo (questionRepository qrepository) {
		return (args) -> {
			log.info("save examplequestions");




			qrepository.save(new Question("kissa"));
			qrepository.save(new Question("koira"));


			log.info("fetch all questions");
			for (Question question : qrepository.findAll()){
				log.info(question.toString());
			}
		};
	}
}
