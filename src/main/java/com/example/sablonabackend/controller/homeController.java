package com.example.sablonabackend.controller;

import com.example.sablonabackend.exceptation.ResourceNotFoundException;
import com.example.sablonabackend.model.Home;
import com.example.sablonabackend.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class homeController {

    @Autowired
    private HomeRepository homeRepository;

    //get all about data
    @GetMapping("/Home")
    public List<Home> getAllHome() {return homeRepository.findAll();}

    //create about rest api
    @PostMapping("/Home")
    public Home createAbout(@RequestBody Home home) { return homeRepository.save(home);}

    //get employee id rest api
    @GetMapping("Home/{id}")
    public ResponseEntity<Home> getHomeById(@PathVariable Long id) {
        Home home = homeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Home does not exist whit this id" + id));
        return ResponseEntity.ok(home);
    }

    // update
    @PutMapping("/Home/{id}")
    public ResponseEntity<Home> updatedHome(@PathVariable Long id) {
        Home home = homeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Home not exist with id :" + id));

        home.setHomeText(home.getHomeText());

        Home updatedHome = homeRepository.save(home);
        return ResponseEntity.ok(updatedHome);
    }

    //Delete

    @DeleteMapping("/home/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAbout(@PathVariable Long id){
        Home home = homeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Home not exist with id :" + id));

        homeRepository.delete(home);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return  ResponseEntity.ok(response);
    }
}

