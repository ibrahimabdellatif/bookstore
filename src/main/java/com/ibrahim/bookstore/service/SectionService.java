package com.ibrahim.bookstore.service;

import com.ibrahim.bookstore.model.Section;
import com.ibrahim.bookstore.repository.SectionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SectionService {
    private final SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }


    public Iterable<Section> getAll(){
        return sectionRepository.findAll();
    }

    public void addSection(Section section){
        sectionRepository.save(section);
    }

    public void updateSection(long sectionId,Section section){
        Optional<Section> section1 = sectionRepository.findById(sectionId);
        if (section1.isPresent()) {
            section1.get().setSectionName(section.getSectionName());
            sectionRepository.save(section1.get());
        }
    }

}
