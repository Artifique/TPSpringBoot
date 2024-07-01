package com.example.gest_ticket.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "base_connaissance")
@Getter
@Setter
@NoArgsConstructor
public class BaseConnaissance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String titre;
    @Column(length = 50)
    private String contenu;
    @Column(length = 50)
    private Date date_creation=new Date();
    private Date date_modification=new Date();

    @OneToMany(mappedBy = "baseConnaissance", cascade = CascadeType.ALL)
    private List<Formateur> formateurs;
    @OneToMany(mappedBy = "baseConnaissance",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Apprenant> apprenants;

}
