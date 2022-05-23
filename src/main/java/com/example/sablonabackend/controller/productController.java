package com.example.sablonabackend.controller;

import com.example.sablonabackend.exceptation.ResourceNotFoundException;
import com.example.sablonabackend.model.Product;
import com.example.sablonabackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")

public class productController {

    @Autowired
    private ProductRepository productRepository;

    //get all about data
    @GetMapping("/Product")
    public List<Product> getAllAbout() {return productRepository.findAll();}

    //create about rest api
    @PostMapping("/Product")
    public Product createAbout(@RequestBody Product product) { return productRepository.save(product);}

    //get employee id rest api
    @GetMapping("Product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product does not exist whit this id" + id));
        return ResponseEntity.ok(product);
    }

    // update
    @PutMapping("/Product/{id}")
    public ResponseEntity<Product> updatedProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));

        product.setProductText(product.getProductText());

        Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    //Delete

    @DeleteMapping("/Product/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));

        productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return  ResponseEntity.ok(response);
    }
}

