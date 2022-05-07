package com.example.ohjelmistoprojekti;

import com.example.ohjelmistoprojekti.answer.Answer;
import com.example.ohjelmistoprojekti.answer.AnswerRepository;
import com.example.ohjelmistoprojekti.question.Question;
import com.example.ohjelmistoprojekti.question.QuestionRepository;
import com.example.ohjelmistoprojekti.user.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner questionDemo(QuestionRepository qrepository, AnswerRepository arepository, UserRepository urepository) {
        return args -> {
            log.info("save examplequestions");

            qrepository.save(new Question("kysymys"));
            qrepository.save(new Question("kysymys2"));

            arepository.save(new Answer("asd", qrepository.findByTitle("kysymys").get(0)));
            arepository.save(new Answer("asas", qrepository.findByTitle("kysymys2").get(0)));

            User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "mallispo@asd", "USER");
            User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "mallispo2@asd", "ADMIN");

            urepository.save(user1);
            urepository.save(user2);

            log.info("fetch all questions");
            for (Question question : qrepository.findAll()){
                log.info(question.toString());
            }
        };
    }
}