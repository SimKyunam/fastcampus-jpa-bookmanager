package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Book;
import com.example.bookmanager.domain.Publisher;
import com.example.bookmanager.domain.Review;
import com.example.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void bookTest(){
        Book book = new Book();
        book.setName("JPA 책");
//        book.setAuthorId(1L);
//        book.setPublisherId(1L);

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }

    @Test
    @Transactional
    void bookRelationTest(){
        givenBookAndReview();

        User user = userRepository.findByEmail("martin@fastcampus.com");

        System.out.println("Review : " + user.getReviews());
        System.out.println("Book : " + user.getReviews().get(0).getBook());
        System.out.println("Publisher : " + user.getReviews().get(0).getBook().getPublisher());
    }

    @Test
    void bookCascadeTest(){
        Book book = new Book();
        book.setName("JPA 책");

        Publisher publisher = new Publisher();
        publisher.setName("테스트 출판사");

        book.setPublisher(publisher); //영속화 하지 않은 상태에서 setter는 연관관계 맺기가 힘듬
        bookRepository.save(book);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers : " + publisherRepository.findAll());

        Book book1 = bookRepository.findById(1L).get();
        book1.getPublisher().setName("변경된 출판사");

        bookRepository.save(book1);

        System.out.println("publishers : " + publisherRepository.findAll());

        Book book2 = bookRepository.findById(1L).get();
//        bookRepository.delete(book2);

        Book book3 = bookRepository.findById(1L).get();
        book3.setPublisher(null);

        bookRepository.save(book3);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers : " + publisherRepository.findAll());
        System.out.println("book3-publisher : " + bookRepository.findById(1L).get().getPublisher());
    }

    @Test
    void bookRemoveCascadeTest(){
        bookRepository.deleteById(1L);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers : " + publisherRepository.findAll());

        bookRepository.findAll().forEach(book -> System.out.println(book.getPublisher()));
    }

    @Test
    void softDelete() {
//        System.out.println(bookRepository.findById(3L));
//        bookRepository.findAll().forEach(System.out::println);

//        bookRepository.findAllByDeletedFalse().forEach(System.out::println);
        bookRepository.findByCategoryIsNullAndDeletedFalse().forEach(System.out::println);
    }

    @Test
    void queryTest(){
//        bookRepository.findAll().forEach(System.out::println);

//        System.out.println("findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual : "
//        + bookRepository.findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual(
//            "JPA 초격자 패키지",
//            LocalDateTime.now().minusDays(1L),
//            LocalDateTime.now().minusDays(1L)
//        ));

//        System.out.println("findByNameRecently : "
//                + bookRepository.findByNameRecently(
//                    "JPA 초격자 패키지",
//                    LocalDateTime.now().minusDays(1L),
//                    LocalDateTime.now().minusDays(1L)));

//        System.out.println(bookRepository.findBookNameAndCategory());

//        bookRepository.findBookNameAndCategory().forEach(tuple -> {
//            System.out.println(tuple.get(0) + " : " + tuple.get(1));
//        });

        bookRepository.findBookNameAndCategory().forEach(b -> {
            System.out.println(b.getName() + " : " + b.getCategory());
        });

        bookRepository.findBookNameAndCategory(PageRequest.of(1, 1)).forEach(
            bookNameAndCategory -> System.out.println(bookNameAndCategory.getName() + " : " + bookNameAndCategory.getCategory()));

        bookRepository.findBookNameAndCategory(PageRequest.of(0, 1)).forEach(
                bookNameAndCategory -> System.out.println(bookNameAndCategory.getName() + " : " + bookNameAndCategory.getCategory()));
    }

    private void givenBookAndReview(){
        givenReview(givenUser(), givenBook(givenPublisher()));
    }

    private User givenUser(){
        return userRepository.findByEmail("martin@fastcampus.com");
    }

    private void givenReview(User user, Book book){
        Review review = new Review();
        review.setTitle("내 인생 책");
        review.setContent("너무너무 재밌는 책이에요.");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);
    }

    private Book givenBook(Publisher publisher){
        Book book = new Book();
        book.setName("JPA 책");
        book.setPublisher(publisher);

        return bookRepository.save(book);
    }

    private Publisher givenPublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("나라출판사사");

        return publisherRepository.save(publisher);
    }
}