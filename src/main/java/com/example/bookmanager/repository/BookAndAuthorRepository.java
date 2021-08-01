package com.example.bookmanager.repository;

import com.example.bookmanager.domain.BookAndAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookAndAuthorRepository extends JpaRepository<BookAndAuthor, Long> {
}
