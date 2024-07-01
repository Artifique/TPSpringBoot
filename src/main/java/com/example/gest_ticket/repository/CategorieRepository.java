package com.example.gest_ticket.repository;

import com.example.gest_ticket.modele.CategorieTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<CategorieTicket,Long> {
}
