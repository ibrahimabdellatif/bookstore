package com.ibrahim.bookstore.service;

import com.ibrahim.bookstore.model.Book;
import com.ibrahim.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
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

    public void updateBook(long id , Map<String , Object> fields){
        Optional<Book> book = bookRepository.findById(id);

        if (book.isPresent()){
            fields.forEach((key, value)->{
//                here we get the column name to update
                Field field = ReflectionUtils.findField(Book.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field,book.get(),value);
            });
            bookRepository.save(book.get());
        }
    }

    public Iterable<Book> getBooksByAuthorId(int authorId){
        return bookRepository.getBooksByAuthorId(authorId);
    }
    public Iterable<Book> getBooksByAuthorName(String authorName){
        return bookRepository.getBooksByAuthorName(authorName);
    }

    public  void addBook(Book book){
        bookRepository.save(book);
    }

    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

}
