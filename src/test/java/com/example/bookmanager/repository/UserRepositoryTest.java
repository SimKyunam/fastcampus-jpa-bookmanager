package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //스프링 컨텍스트를 사용하겠다.
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud(){ //create, read, update, delete
        userRepository.save(new User());

        System.out.println(">>> " + userRepository.findAll());
    }
}