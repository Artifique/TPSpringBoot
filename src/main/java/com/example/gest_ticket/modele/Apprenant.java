package com.example.gest_ticket.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name="apprenant")
@Getter
@Setter
@NoArgsConstructor
public class Apprenant extends User {

    @ManyToOne
    @JoinColumn(name = "admin_id",nullable =false)
    private Admin admin;
    @OneToMany(mappedBy = "apprenant",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Ticket> tickets;
    @ManyToOne
    @JoinColumn(name = "base_id",nullable = false)
    private BaseConnaissance baseConnaissance;
}
