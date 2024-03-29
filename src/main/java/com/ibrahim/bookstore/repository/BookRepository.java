package com.ibrahim.bookstore.repository;

import com.ibrahim.bookstore.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    /* operations i need in book with database
    >> Select Queries section:
    1- get all books
    2- get books by author
    3- get book by title
    4- get book by language
    5- get book by publish year
    6- get books by section
    >> modify the database:
    1- insert new book with all information
    2- modify a book details
    3- insert new section
    4- insert new author
    5- delete author, book, section
    *
    * */

    //    @Query("select * from book")
//    List<Book> getAllBook();
//Just for testing
    @Override
    List<Book> findAll();

    @Query(value = "select * from book where section_id = :sectionId", nativeQuery = true)
    List<Book> getBookBySection(int sectionId);

//    @Query("select * from book where author_id = :authorId")
//    List<Book> getBookByAuthor(int authorId);
//
//    @Query("select * from book where book_language = :language")
//    List<Book> getBookByLanguage(String language);
//
////    see if here error when calling this function
//    @Query("select * from book where title like %:title% ")
//    List<Book> getBookByTitle(String title);
//
//    @Query("select * from book where publishing_year = :year")
//    List<Book> getBookByPublishingYear(int year);
//
    @Modifying
    @Query(value = "insert into book(title , description, cover_image, publishing_year, book_language, book_link, section_id , author_id) values(:title , :description, :cover_image, :publishing_year, :book_language, :book_link, :section_id , :author_id)", nativeQuery = true)
    void addBook(String title ,String description,String cover_image,int publishing_year,String book_language,String book_link,int section_id ,int author_id);
//
////    need to test this approach
////    @Override
////    <S extends Book> Iterable<S> saveAll(Iterable<S> entities);
//
    @Modifying
    @Query(value = "insert into book_section(section_name) values(:sectionName)", nativeQuery = true)
    void addSection(String sectionName);
//
//
////    The TRUNCATE TABLE statement is another option for removing all data from a table. However, it's generally considered more efficient than DELETE for large tables.
    @Modifying
    @Query(value = "TRUNCATE TABLE  book", nativeQuery = true)
    void deleteAllBooks();
////
////    @Modifying
////    @Query("TRUNCATE TABLE  book_section")
////    void deleteAllSections();
////
////    @Modifying
////    @Query("TRUNCATE TABLE  author")
////    void deleteAllAuthors();
//
    @Modifying
    @Query(value = "update book set title = :title, description = :description where book_id = :bookId", nativeQuery = true)
    void updateBook(Optional<String> title, Optional<String> description , Long bookId);

    @Query(value = "select * from book where author_id = :authorId" , nativeQuery = true)
    Iterable<Book> getBooksByAuthorId(int authorId);
    @Query(value = "SELECT b.*, a.author_name FROM book as b left join author as a on b.author_id = a.author_id where author_name = :authorName" , nativeQuery = true)
    Iterable<Book> getBooksByAuthorName(String authorName);


}