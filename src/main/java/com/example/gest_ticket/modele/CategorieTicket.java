package com.example.gest_ticket.modele;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="categorie_ticket")
public class CategorieTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @Column(length = 50)
    private String titre;

   @OneToMany(mappedBy = "categorieTicket",cascade = CascadeType.ALL)
   private List<Ticket> tickets;

}
