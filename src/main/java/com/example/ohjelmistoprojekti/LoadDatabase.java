package com.example.ohjelmistoprojekti;

import com.example.ohjelmistoprojekti.model.Answer;
import com.example.ohjelmistoprojekti.model.AnswerRepository;
import com.example.ohjelmistoprojekti.model.Question;
import com.example.ohjelmistoprojekti.model.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner questionDemo(QuestionRepository qrepository, AnswerRepository arepository) {
        return args -> {
            log.info("save examplequestions");

            qrepository.save(new Question("kysymys"));
            qrepository.save(new Question("kysymys2"));


            arepository.save(new Answer("asd", qrepository.findByTitle("kysymys").get(0)));
            arepository.save(new Answer("asas", qrepository.findByTitle("kysymys2").get(0)));


            log.info("fetch all questions");
            for (Question question : qrepository.findAll()){
                log.info(question.toString());
            }
        };
    }
}