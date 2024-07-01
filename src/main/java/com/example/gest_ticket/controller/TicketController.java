package com.example.gest_ticket.controller;


import com.example.gest_ticket.enumerations.TypeStatut;
import com.example.gest_ticket.modele.Ticket;
import com.example.gest_ticket.service.Implementation.TicketServiceImpl;
import com.example.gest_ticket.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@AllArgsConstructor
public class TicketController {
    @Autowired
    private TicketServiceImpl ticketServiceImpl;
    private final TicketService ticketService;

    @PostMapping("/addticket")
    public Ticket creerTicket(@RequestBody Ticket ticket){
        ticket.setStatut(TypeStatut.OUVERT);
        return ticketService.creerTicket(ticket);
    }
    @GetMapping("/readticket")
    public List<Ticket> listerTicket() {
     return ticketService.listerTicket();
    }
    @PutMapping("/updateticket/{id}")
    public Ticket modifierTicket(@PathVariable Long id, @RequestBody Ticket ticket){
        return ticketService.modifierTicket(id,ticket);
    }
    @DeleteMapping("/deleteticket/{id}")
    public String supprimerTicket(@PathVariable Long id){
        return ticketService.supprimerTicket(id);
    }
    @PutMapping("/{id}/repondre")
    public Ticket repondreAuTicket(@PathVariable Long id, @RequestBody String reponse) {

        return ticketServiceImpl.repondreAuTicket(id, reponse);
    }

}
