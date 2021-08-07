package com.example.bookmanager.service;

import com.example.bookmanager.domain.User;
import com.example.bookmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void put(){
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUser@test.com");

//        userRepository.save(user);
        entityManager.persist(user);
//        entityManager.detach(user);

        user.setName("newUserAfterPersist");

        System.out.println("--------------------------------");
        entityManager.merge(user);
//        entityManager.flush();
//        entityManager.clear();

        User user1 = userRepository.findById(1L).get();
        entityManager.remove(user1);

        user1.setName("marrrrrrrrrrrrrr");
        entityManager.merge(user1);
    }
}
