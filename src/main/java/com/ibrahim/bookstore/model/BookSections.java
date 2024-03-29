package com.ibrahim.bookstore.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "book_section")
public class BookSections {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "section_id", nullable = false)
    private Long sectionId;
    @Column(name = "section_name")
    private String sectionName;

    public Long getId() {
        return sectionId;
    }

    public void setId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}
