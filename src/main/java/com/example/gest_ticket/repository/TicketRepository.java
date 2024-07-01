package com.example.gest_ticket.repository;

import com.example.gest_ticket.modele.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
