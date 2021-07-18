package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //스프링 컨텍스트를 사용하겠다.
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    void crud(){ //create, read, update, delete
        //테스트 데이터
//        User user1 = new User("Kim", "kim@naver.com");
//        User user2 = new User("Hong", "hong@naver.com");



        //----------------paging----------------
//        Page<User> users = userRepository.findAll(PageRequest.of(0, 3));
//
//        System.out.println("page : " + users);
//        System.out.println("totalElements : " + users.getTotalElements());
//        System.out.println("totalPages : " + users.getTotalPages());
//        System.out.println("numberOfElements : " + users.getNumberOfElements()); //레코드 수 (zero-base 0에서부터 시작)
//        System.out.println("sort : " + users.getSort());
//        System.out.println("size : " + users.getSize()); //페이징 나누는 수
//
//        users.getContent().forEach(System.out::println);


        //----------------select----------------
//        User user = userRepository.getOne(1L); //getOne Entity에 대해서 lazy한 로딩
//        User user = userRepository.findById(1L).orElse(null);
//        long count = userRepository.count();
//        boolean exists = userRepository.existsById(1L);


        //----------------insert----------------
//        userRepository.save(user1);
//        userRepository.saveAll(Lists.newArrayList(user1, user2));

        //flush: 쿼리 변화x 디비 반영시점을 조정, 동작확인 어렵다.
//        userRepository.save(new User("Kim", "kim@naver.com"));
//        userRepository.flush();
//        userRepository.saveAndFlush(new User("Kim", "kim@naver.com"));


        //----------------List select----------------
//        List<User> users = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));
//        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));


        //----------------List select----------------
//        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
//        userRepository.deleteById(1L);
//        userRepository.deleteAll(); //entity 확인하고 지움
//        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L, 3L))); //entity 확인 안하고 지움
//        userRepository.deleteAllInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L))); //entity 확인 안하고 지움
//        userRepository.deleteAllInBatch();

        //----------------확인용----------------
//        userRepository.findAll().forEach(System.out::println);
//        System.out.println("page : " + users);
    }
}