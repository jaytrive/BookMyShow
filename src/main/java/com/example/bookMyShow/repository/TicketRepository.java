package com.example.bookMyShow.repository;

import com.example.bookMyShow.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
