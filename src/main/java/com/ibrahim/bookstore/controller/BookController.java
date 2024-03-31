package com.ibrahim.bookstore.controller;

import com.ibrahim.bookstore.model.Author;
import com.ibrahim.bookstore.model.Book;
import com.ibrahim.bookstore.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public Iterable<Book> getAllBook(@RequestBody(required = false) String title){
            return bookService.getAllBooks();
    }


    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @GetMapping("/section/{id}")
    public List<Book> getBooksBySection(@PathVariable int id){
        return bookService.getBooksBySection(id);
    }

    @PatchMapping("/edit-book/{id}")
    public void updateBook(@PathVariable long id , @RequestBody Map<String , Object> bookFields){
        bookService.updateBook(id,bookFields);
    }

    @GetMapping("/author/{id}")
    public Iterable<Book> getBooksByAuthorId(@PathVariable int id){
        return bookService.getBooksByAuthorId(id);
    }
    @GetMapping("/author")
    public Iterable<Book> getBooksByAuthorName(@RequestBody Author author){
        return bookService.getBooksByAuthorName(author.getAuthorName());
    }

    @PostMapping("/add-book")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        bookService.addBook(book);
        return ResponseEntity.ok(book);
    }
}
