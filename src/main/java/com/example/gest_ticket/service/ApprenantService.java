package com.example.gest_ticket.service;

import com.example.gest_ticket.modele.Apprenant;

import java.util.List;

public interface ApprenantService {
    Apprenant creerApprenant (Apprenant apprenant);
    Apprenant modifierApprenant(Long id, Apprenant apprenant);
    List<Apprenant> listerApprenant();
    String supprimerApprenant(Long id);

}
