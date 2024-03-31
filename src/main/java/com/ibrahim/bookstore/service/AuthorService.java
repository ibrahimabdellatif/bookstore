package com.ibrahim.bookstore.service;

import com.ibrahim.bookstore.model.Author;
import com.ibrahim.bookstore.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Iterable<Author> getAllAuthors(){
        return authorRepository.findAll();
    }
    public Optional<Author> getAuthorById(int id){
        return authorRepository.findById(id);
    }

//    get all books by author not add here it will add in bookService

    @Transactional
    public void updateAuthorName(int authorId , String authorName){
        authorRepository.updateAuthorName(authorId, authorName);
    }

    @Transactional
    public void addAuthor(String authorName){
        authorRepository.addAuthor(authorName);
    }

    public void save(Author author){
        authorRepository.save(author);
    }

}
