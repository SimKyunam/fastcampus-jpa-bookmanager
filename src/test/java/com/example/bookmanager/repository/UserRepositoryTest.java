package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

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


        //----------------Example (QueryByExampleExecutor) 잘 안씀----------------
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("name")
//                .withMatcher("email", endsWith());
//        Example<User> example = Example.of(new User("ma", "fastcampus.com"), matcher);

//        Example<User> example = Example.of(new User("ma", "fastcampus.com"));

//        User user = new User();
//        user.setEmail("slow");
//        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains());
//        Example<User> example = Example.of(user, matcher);
//
//        userRepository.findAll(example).forEach(System.out::println);

        //----------------update----------------
        userRepository.save(new User("david", "david@gmail.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-update@gmail.com");

        userRepository.save(user);


        //----------------확인용----------------
//        userRepository.findAll().forEach(System.out::println);
//        System.out.println("page : " + users);
    }

    @Test
    public void select(){
//        System.out.println(userRepository.findByName("dennis"));

//        System.out.println("findByEmail : " + userRepository.findByEmail("martin@fastcampus.com"));
//        System.out.println("getByEmail : " + userRepository.getByEmail("martin@fastcampus.com"));
//        System.out.println("readByEmail : " + userRepository.readByEmail("martin@fastcampus.com"));
//        System.out.println("queryByEmail : " + userRepository.queryByEmail("martin@fastcampus.com"));
//        System.out.println("searchByEmail : " + userRepository.searchByEmail("martin@fastcampus.com"));
//        System.out.println("streamByEmail : " + userRepository.streamByEmail("martin@fastcampus.com"));
//        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin@fastcampus.com"));
//        System.out.println("findSomethingByEmail : " + userRepository.findSomethingByEmail("martin@fastcampus.com"));

        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("martin"));
        System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("martin"));
        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("martin"));
    }

}