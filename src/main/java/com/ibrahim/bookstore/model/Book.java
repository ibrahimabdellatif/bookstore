package com.ibrahim.bookstore.model;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;


@Entity
@Table(name = "book")
public class Book {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "book_id", nullable = false)
    private Long id;

    private String title;
    private String description;
    @Column(name = "cover_image")
    private String coverImagePath;
    @Column(name = "publishing_year")
    private int publishingYear;
    @Column(name = "book_language")
    private String bookLanguage;
    @Column(name = "section_id")
    private int sectionId;
    @Column(name = "author_id")
    private int authorId;

    @Column(name = "book_link")
    private String bookLink;

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookLink() {
        return bookLink;
    }

    public void setBookLink(String bookLink) {
        this.bookLink = bookLink;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverImagePath() {
        return coverImagePath;
    }

    public void setCoverImagePath(String coverImagePath) {
        this.coverImagePath = coverImagePath;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
