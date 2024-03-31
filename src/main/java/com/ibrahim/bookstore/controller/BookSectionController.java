package com.ibrahim.bookstore.controller;

import com.ibrahim.bookstore.model.Section;
import com.ibrahim.bookstore.service.SectionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/section")
public class BookSectionController {

    private final SectionService sectionService;


    public BookSectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping()
    public Iterable<Section> getAllSections(){
        return sectionService.getAll();
    }

    @PostMapping("/add")
    public void addSection(@RequestBody Section section){
        sectionService.addSection(section);
    }
    @PatchMapping("/edit-section/{id}")
    public void updateSection(@PathVariable long id,@RequestBody Section section){
        sectionService.updateSection(id , section);
    }

}
