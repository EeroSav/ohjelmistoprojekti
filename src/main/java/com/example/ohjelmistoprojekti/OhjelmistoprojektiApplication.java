package com.example.ohjelmistoprojekti;

import com.example.ohjelmistoprojekti.model.Category;
import com.example.ohjelmistoprojekti.model.CategoryRepository;
import com.example.ohjelmistoprojekti.model.Question;
import com.example.ohjelmistoprojekti.model.questionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OhjelmistoprojektiApplication {
	private static final Logger log = LoggerFactory.getLogger(OhjelmistoprojektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OhjelmistoprojektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner questionDemo (questionRepository qrepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save examplequestions");

			crepository.save(new Category("teksti"));
			crepository.save(new Category("radio button"));
			crepository.save(new Category("checkbox"));
			crepository.save(new Category("selection list"));


			qrepository.save(new Question("kissa",
					crepository.findByName("teksti").get(0)));
			qrepository.save(new Question("koira",
					crepository.findByName("teksti").get(0)));

			log.info("fetch all questions");
			for (Question question : qrepository.findAll()){
				log.info(question.toString());
			}
		};
	}
}
