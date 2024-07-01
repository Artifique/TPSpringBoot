package com.example.gest_ticket.service;

import com.example.gest_ticket.modele.Formateur;
import com.example.gest_ticket.modele.Ticket;

import java.util.List;

public interface TicketService {
    Ticket creerTicket(Ticket ticket);
    List<Ticket> listerTicket();
    Ticket modifierTicket(Long id,Ticket ticket);
    String supprimerTicket(Long id);
}
