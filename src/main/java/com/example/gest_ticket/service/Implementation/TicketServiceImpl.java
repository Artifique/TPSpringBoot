package com.example.gest_ticket.service.Implementation;

import com.example.gest_ticket.enumerations.TypeStatut;
import com.example.gest_ticket.modele.Ticket;
import com.example.gest_ticket.repository.TicketRepository;
import com.example.gest_ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private NotificationServiceImpl notificationServiceImpl;

    @Autowired
    private SendEmail sendEmail;
    @Override
    public Ticket creerTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> listerTicket() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket modifierTicket(Long id, Ticket ticket) {
        return ticketRepository.findById(id)
                .map(ticket1 -> {
                    ticket1.setTitre(ticket.getTitre());
                    ticket1.setDescription(ticket.getDescription());
                    ticket1.setPriorite(ticket.getPriorite());
                    ticket1.setStatut(ticket.getStatut());
                    ticket1.setDate_cre(ticket.getDate_cre());
                    return ticketRepository.save(ticket1);
                }).orElseThrow(()-> new RuntimeException("Le formateur n'existe pas"));
    }

    @Override
    public String supprimerTicket(Long id) {
        ticketRepository.deleteById(id);
        return "Ticket supprimé avec succès!!";
    }

    public Ticket repondreAuTicket(Long ticketId, String reponse) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ticket ID"));

        // Logique pour répondre au ticket

        ticket.setReponse(reponse);
        ticket.setStatut(TypeStatut.RESOLU);


        // Enregistrer le ticket mis à jour
       // ticketRepository.save(ticket);

        // Envoyer une notification à l'apprenant
        //notificationServiceImpl.envoyerNotification(ticket, "Votre ticket a été répondu : " + reponse);

        //return ticket;
        String emailApprenant =ticket.getApprenant().getEmail();
        String subject="Votre ticket a été repondu";
        String message="Bonjour"+ticket.getApprenant().getNom() +",\n\n Votre ticket avec la description:\""+ticket.getDescription() +"\" a ete repondu.\n\n Reponse:"+reponse;
        sendEmail.sendSimpleMessage(emailApprenant,subject,message);
        return ticketRepository.save(ticket);
    }



}
