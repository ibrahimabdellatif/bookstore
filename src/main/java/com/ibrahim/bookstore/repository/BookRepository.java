package com.ibrahim.bookstore.repository;

import com.ibrahim.bookstore.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select * from book where section_id = :sectionId", nativeQuery = true)
    List<Book> getBookBySection(int sectionId);

    @Query(value = "select * from book where author_id = :authorId" , nativeQuery = true)
    Iterable<Book> getBooksByAuthorId(int authorId);
    @Query(value = "SELECT b.*, a.author_name FROM book as b left join author as a on b.author_id = a.author_id where author_name = :authorName" , nativeQuery = true)
    Iterable<Book> getBooksByAuthorName(String authorName);

}