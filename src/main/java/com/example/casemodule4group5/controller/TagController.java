package com.example.casemodule4group5.controller;

import com.example.casemodule4group5.model.entity.Tag;
import com.example.casemodule4group5.service.tag.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/tags")
public class TagController {
    @Autowired
    private ITagService tagService;

    @GetMapping
    public ResponseEntity<Page<Tag>> findAll(Pageable pageable) {
        return new ResponseEntity<>(tagService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tag> save(@RequestBody Tag tag) {
        return new ResponseEntity<>(tagService.save(tag), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tag> deleteTag(@PathVariable Long id) {
        Optional<Tag> tagOptional = tagService.findById(id);
        if (!tagOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tagService.removeById(id);
        return new ResponseEntity<>(tagOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag> updateTag(@PathVariable Long id, @RequestBody Tag tag) {
        Optional<Tag> tagOptional = tagService.findById(id);
        if (!tagOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tag.setId(id);
        return new ResponseEntity<>(tagService.save(tag), HttpStatus.OK);
    }
}
