package com.example.gest_ticket.repository;

import com.example.gest_ticket.modele.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {

}
