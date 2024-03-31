package com.ibrahim.bookstore.repository;

import com.ibrahim.bookstore.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository  extends JpaRepository<Section ,Long> {
}
