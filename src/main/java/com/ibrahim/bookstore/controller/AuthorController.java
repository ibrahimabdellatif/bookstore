package com.ibrahim.bookstore.controller;

import com.ibrahim.bookstore.model.Author;
import com.ibrahim.bookstore.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public Iterable<Author> getAllAuthor() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Optional<Author> getAuthorById(@PathVariable int id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping("/add")
    public void addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author.getAuthorName());
    }

    @PatchMapping("/update/{authorId}")
    public void updateAuthorName(@PathVariable int authorId, @RequestBody Author author) {
        authorService.updateAuthorName(authorId, author.getAuthorName());
    }

}
