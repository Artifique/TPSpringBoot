package com.example.gest_ticket.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notification")
@Getter
@Setter
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 150)
    private String message;
    @ManyToOne
    @JoinColumn(name = "apprenant_id",nullable = false)
    private Apprenant apprenant;
    @ManyToOne
    @JoinColumn(name = "formateur_id",nullable = false)
    private Formateur formateur;
    @ManyToOne
    @JoinColumn(name = "ticket_id",nullable = false)
    private Ticket ticket;

}
