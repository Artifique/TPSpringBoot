package com.example.gest_ticket.service;

import com.example.gest_ticket.modele.Admin;
import com.example.gest_ticket.modele.Apprenant;
import com.example.gest_ticket.modele.Formateur;

import java.util.List;

public interface AdminService {
   Admin creerAdmin(Admin admin);
   List<Admin> listerAdmin();
   Admin modifierAdmin(Long id,Admin admin);
   String supprimerAdmin(Long id);

}
