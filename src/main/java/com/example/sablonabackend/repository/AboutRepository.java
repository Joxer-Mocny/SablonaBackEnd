package com.example.sablonabackend.repository;

import com.example.sablonabackend.model.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends JpaRepository<About, Long> {
}
