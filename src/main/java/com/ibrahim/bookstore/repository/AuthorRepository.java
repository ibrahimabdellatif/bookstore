package com.ibrahim.bookstore.repository;

import com.ibrahim.bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author , Integer> {
    @Modifying
    @Query(value = "update author set author_name = :authorName where author_id = :authorId" , nativeQuery = true)
    void updateAuthorName(int authorId, String authorName);

    @Modifying
    @Query(value = "insert into author(author_name) values (:authorName)" , nativeQuery = true)
    void addAuthor(String authorName);
}
