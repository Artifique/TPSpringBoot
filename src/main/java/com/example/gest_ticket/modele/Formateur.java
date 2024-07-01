package com.example.gest_ticket.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "formateur")
@Getter
@Setter
@NoArgsConstructor
public class Formateur extends User {

    @ManyToOne
    @JoinColumn(name = "base_id",nullable =true)
    private BaseConnaissance baseConnaissance;

    @OneToMany(mappedBy = "formateur",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Ticket> ticketList;

    @OneToMany(mappedBy = "formateur",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Notification> notifications;


}
