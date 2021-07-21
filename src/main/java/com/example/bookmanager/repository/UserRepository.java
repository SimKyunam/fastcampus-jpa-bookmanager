package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Set<User> findByName(String name);

    Set<User> findUserByNameIs(String names);

    Set<User> findUserByName(String names);

    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);

    User findSomethingByEmail(String email);

    List<User> findFirst1ByName(String name);

    List<User> findTop1ByName(String name);

    List<User> findLast1ByName(String name);

    List<User> findByEmailAndName(String email, String name);

    List<User> findByEmailOrName(String email, String name);

    List<User> findByCreatedAtAfter(LocalDateTime yesterday);

    List<User> findByIdAfter(Long id);

    List<User> findByCreatedAtGreaterThan(LocalDateTime yesterday);

    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);

    List<User> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);

    List<User> findByIdBetween(Long id1, Long id2);

    List<User> findByIdLessThanEqual(Long id1);

    List<User> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);

    List<User> findByIdNotNull();

//    List<User> findByAddressIsNotEmpty();

    List<User> findByNameIn(List<String> names);

    List<User> findByNameStartingWith(String names);

    List<User> findByNameEndingWith(String names);

    List<User> findByNameContains(String names);

    List<User> findByNameLike(String names);

    List<User> findTopByNameOrderByIdDesc(String names);

    List<User> findTopByNameOrderById(String names);

    List<User> findFirstByNameOrderByIdDescEmailAsc(String names);

    List<User> findFirstByName(String name, Sort sort);

    Page<User> findByName(String name, Pageable pageable);

    @Query(value="select * from user limit 1;", nativeQuery = true)
    Map<String, Object> findRowRecord();
}
