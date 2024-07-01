package com.example.gest_ticket.modele;

import com.example.gest_ticket.enumerations.TypePriorite;
import com.example.gest_ticket.enumerations.TypeStatut;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String titre;
    @Column(length = 50)
    private String description;
    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private TypePriorite priorite;
    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private TypeStatut statut;
    private String date_cre;
    @Column(length = 250)
    private  String reponse;
    //private Boolean  EstRepondu=false;
    @ManyToOne
    @JoinColumn(name = "formateur_id",nullable = false)
    private Formateur formateur;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private CategorieTicket categorieTicket;
    @ManyToOne
    @JoinColumn(name = "apprenant_id",nullable = false)
    private Apprenant apprenant;
    @OneToMany(mappedBy = "ticket")
    private List<Notification> notifications;

}
