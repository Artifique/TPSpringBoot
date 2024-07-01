package com.example.gest_ticket.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "admin")
@Getter
@Setter
@NoArgsConstructor
public class Admin extends User {

    @OneToMany(mappedBy = "admin",cascade =CascadeType.ALL,orphanRemoval = true)
    private List<Apprenant> apprenants;


}
