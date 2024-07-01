package com.example.gest_ticket.repository;

import com.example.gest_ticket.modele.Admin;
import com.example.gest_ticket.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByNom(String nom);
}
