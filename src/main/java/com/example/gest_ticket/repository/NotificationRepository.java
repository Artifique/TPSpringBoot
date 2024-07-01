package com.example.gest_ticket.repository;

import com.example.gest_ticket.modele.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
