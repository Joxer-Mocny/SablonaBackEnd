package com.example.sablonabackend.repository;

import com.example.sablonabackend.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {
}
