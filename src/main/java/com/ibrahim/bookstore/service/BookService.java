package com.ibrahim.bookstore.service;

import com.ibrahim.bookstore.model.Book;
import com.ibrahim.bookstore.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public List<Book> getBooksBySection(int sectionId){
        return bookRepository.getBookBySection(sectionId);
    }

    public void updateBook(long id , Optional<Book> book){
        bookRepository.updateBook(Optional.of(book.get().getTitle()) , Optional.of(book.get().getDescription()), id);
    }

    public Iterable<Book> getBooksByAuthorId(int authorId){
        return bookRepository.getBooksByAuthorId(authorId);
    }
    public Iterable<Book> getBooksByAuthorName(String authorName){
        return bookRepository.getBooksByAuthorName(authorName);
    }


//    public Iterable<Book> getSearchedBook(String title){
//        return bookRepository.getBookByTitle(title);
//    }

}
