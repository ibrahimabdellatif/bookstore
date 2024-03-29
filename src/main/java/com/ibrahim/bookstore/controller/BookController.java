package com.ibrahim.bookstore.controller;

import com.ibrahim.bookstore.model.Author;
import com.ibrahim.bookstore.model.Book;
import com.ibrahim.bookstore.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public Iterable<Book> getAllBook(@RequestBody(required = false) String title){
            return bookService.getAllBooks();
    }

    @GetMapping("/section/{id}")
    public List<Book> getBooksBySection(@PathVariable int id){
        return bookService.getBooksBySection(id);
    }

    @PatchMapping("/edit-book/{id}")
    public void updateBook(@PathVariable long id , @RequestBody Optional<Book> book){
        bookService.updateBook(id,book);
    }

    @GetMapping("/author/{id}")
    public Iterable<Book> getBooksByAuthorId(@PathVariable int id){
        return bookService.getBooksByAuthorId(id);
    }
    @GetMapping("/author")
    public Iterable<Book> getBooksByAuthorName(@RequestBody Author author){
        return bookService.getBooksByAuthorName(author.getAuthorName());
    }
}
