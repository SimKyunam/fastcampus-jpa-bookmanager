package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Gender;
import com.example.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.hibernate.criterion.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.*;

@SpringBootTest //스프링 컨텍스트를 사용하겠다.
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Test
    @Transactional
    void crud(){ //create, read, update, delete
        //테스트 데이터
//        User user1 = new User("Kim", "kim@naver.com");
//        User user2 = new User("Hong", "hong@naver.com");

        //----------------paging----------------
//        Page<User> users = userRepository.findAll(PageRequest.of(0, 3));
//
//        System.out.println("page : " + users); //객체
//        System.out.println("totalElements : " + users.getTotalElements()); //총 레코드 수
//        System.out.println("totalPages : " + users.getTotalPages()); //총 페이지 수
//        System.out.println("numberOfElements : " + users.getNumberOfElements()); //현재 페이지의 레코드 수 (zero-base 0에서부터 시작)
//        System.out.println("sort : " + users.getSort()); //소트 방식
//        System.out.println("size : " + users.getSize()); //페이징 나누는 수
//
//        users.getContent().forEach(System.out::println);


        //----------------select----------------
//        User user = userRepository.getOne(1L); //getOne Entity에 대해서 lazy한 로딩
//        User user = userRepository.findById(1L).orElse(null);
//        long count = userRepository.count();
//        boolean exists = userRepository.existsById(1L);


        //----------------insert----------------
//        userRepository.saveAll(Lists.newArrayList(new User("Kim", "kim@naver.com"), new User("Hong", "Hong@naver.com")));

//        flush: 쿼리 변화x 디비 반영시점을 조정, 동작확인 어렵다.
//        userRepository.save(new User("Kim", "kim@naver.com"));
//        userRepository.flush();
//        userRepository.saveAndFlush(new User("Kim", "kim@naver.com"));


        //----------------List select----------------
        //List<User> users = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));
//        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
//        users.stream().forEach(System.out::println); //결과 출력 부분


        //----------------delete ----------------
//        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
//        userRepository.deleteById(1L);
//        userRepository.deleteAll(); //entity 확인하고 지움
//        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L, 3L)));
//        userRepository.deleteAllInBatch();
//        userRepository.deleteAllInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L))); //entity 확인 안하고 지움


        //----------------Example (QueryByExampleExecutor) 잘 안씀----------------
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("name")
//                .withMatcher("email", contains());
//        Example<User> example = Example.of(new User("ma", "fastcampus.com"), matcher);

//        Example<User> example = Example.of(new User("ma", "fastcampus.com"));

//        User user = new User();
//        user.setEmail("slow");
//        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains());
//        Example<User> example = Example.of(user, matcher);
////
//        userRepository.findAll(example).forEach(System.out::println);

        //----------------update----------------
//        userRepository.save(new User("david", "david@gmail.com"));
//
//        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
//        user.setEmail("martin-update@gmail.com");
//
//        userRepository.save(user);


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

//        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("martin"));
//        System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("martin"));
//        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("martin"));

//        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("martin@fastcampus.com", "martin"));
//        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("martin@fastcampus.com", "martin"));
//        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));

//        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));
//        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));

//        System.out.println("findByIdLessThanEqual : " + userRepository.findByIdLessThanEqual(3L));

//        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
//        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));

//        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));

//        System.out.println("findByIdNotNull : " + userRepository.findByIdNotNull());
//        System.out.println("findByAddressIsNotEmpty : " + userRepository.findByAddressIsNotEmpty());

//        System.out.println("findByNameIn : " + userRepository.findByNameIn(Arrays.asList("martin", "denis")));
//        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("martin", "denis")));

//        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("mar"));
//        System.out.println("findByNameStartingWith : " + userRepository.findByNameEndingWith("tin"));
//        System.out.println("findByNameStartingWith : " + userRepository.findByNameContains("art"));

        System.out.println("findByNameLike : " + userRepository.findByNameLike("%art%"));
    }

    @Test
    void pagingAndSortingTest(){
//        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("martin"));
//        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("martin"));

//        System.out.println("findTopByNameOrderByIdDesc : " + userRepository.findTopByNameOrderByIdDesc("martin"));
//        System.out.println("findTopByNameOrderById : " + userRepository.findTopByNameOrderById("martin"));
//        System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("martin"));

//        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("martin", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
//        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("martin", getSort()));

        System.out.println("findByNameWithPaging : "
                + userRepository.findByName("martin", PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")))).getContent());
    }

    private Sort getSort(){
        return Sort.by(
            Sort.Order.desc("id"),
            Sort.Order.asc("email"),
            Sort.Order.asc("createAt"),
            Sort.Order.asc("updateAt")
        );
    }

    @Test
    void insertAndUpdateTest(){
        User user = new User();
        user.setName("martin");
        user.setEmail("martin2@gmail.com");

        userRepository.save(user); //insert

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("KIM");

        userRepository.save(user2); //update
    }

    @Test
    void enumTest(){
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);

        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRowRecord().get("gender"));
    }

    @Test
    void listenerTest(){
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setName("sim");

        userRepository.save(user); //insert

        User user2 = userRepository.findById(1L).get();
        user2.setName("kim");

        userRepository.save(user2); //update

        userRepository.deleteById(4L);
    }

    @Test
    void prePersistTest(){
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setName("Kim");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("test@gmail.com"));
    }

    @Test
    void preUpdateTest(){
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("as-is : " + user);

        user.setName("hong");
        userRepository.save(user);

        System.out.println("to-be : " + userRepository.findAll().get(0));
    }

    @Test
    void userHistoryTest(){
        User user = new User();
        user.setEmail("test-new@gmail.com");
        user.setName("Hong");

        userRepository.save(user);

        user.setName("Hong-new");

        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
    }
}