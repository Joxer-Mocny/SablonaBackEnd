package com.example.sablonabackend.controller;


import com.example.sablonabackend.exceptation.ResourceNotFoundException;
import com.example.sablonabackend.model.About;
import com.example.sablonabackend.repository.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(" /api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class AboutController {

    @Autowired
    private AboutRepository aboutRepository;

    //get all about data
    @GetMapping("/About")
    public List<About> getAllAbout() {return aboutRepository.findAll();}

    //get about rest api
    @PostMapping("/About")
    public About createAbout(@RequestBody About about) { return aboutRepository.save(about);}

    //get employee id rest api
    @GetMapping("About/{id}")
    public ResponseEntity<About> getAboutById(@PathVariable Long id) {
        About about = aboutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("About does not exist whit this id" + id));
        return ResponseEntity.ok(about);
    }

    // update
    @PutMapping("/About/{id}")
    public ResponseEntity<About> updatedAbout(@PathVariable Long id) {
        About about = aboutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("About not exist with id :" + id));

        about.setAboutText(about.getAboutText());

        About updatedAbout = aboutRepository.save(about);
        return ResponseEntity.ok(updatedAbout);
    }

    //Delete

    @DeleteMapping("/about/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAbout(@PathVariable Long id){
        About about = aboutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("About not exist with id :" + id));

        aboutRepository.delete(about);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return  ResponseEntity.ok(response);
    }
}
