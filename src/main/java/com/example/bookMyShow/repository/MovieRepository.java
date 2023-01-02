package com.example.bookMyShow.repository;

import com.example.bookMyShow.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    boolean existsByName(String name);
}
