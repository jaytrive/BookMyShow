package com.example.bookMyShow.repository;

import com.example.bookMyShow.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show,Integer> {
}
