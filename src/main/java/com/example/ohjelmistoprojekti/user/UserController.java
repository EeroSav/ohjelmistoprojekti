package com.example.ohjelmistoprojekti.user;

import com.example.ohjelmistoprojekti.question.Question;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //Hae kaikki käyttäjät, tarpeellisuus??
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/users")
    List<User> allusers() {
        return userRepository.findAll();
    }
}
