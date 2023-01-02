package com.example.bookMyShow.repository;

import com.example.bookMyShow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
