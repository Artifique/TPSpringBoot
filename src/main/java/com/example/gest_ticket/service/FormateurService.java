package com.example.gest_ticket.service;

import com.example.gest_ticket.modele.Formateur;

import java.util.List;

public interface FormateurService {
    Formateur creerFormateur(Formateur formateur);
    List<Formateur> listerFormateur();
    Formateur modifierFormateur(Long id,Formateur formateur);
    String supprimerFormateur(Long id);
}
