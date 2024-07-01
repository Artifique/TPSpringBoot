package com.example.gest_ticket.service;

import com.example.gest_ticket.modele.CategorieTicket;
import com.example.gest_ticket.modele.Formateur;

import java.util.List;

public interface CategorieService {
    CategorieTicket creerCategorie(CategorieTicket categorieTicket);
    List<CategorieTicket> listerCategorie();
    CategorieTicket modifierCategorie(Long id,CategorieTicket categorieTicket);
    String supprimerCategorie(Long id);
}
