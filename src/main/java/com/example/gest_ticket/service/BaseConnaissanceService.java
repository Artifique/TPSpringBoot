package com.example.gest_ticket.service;

import com.example.gest_ticket.modele.Admin;
import com.example.gest_ticket.modele.BaseConnaissance;

import java.util.List;
public interface BaseConnaissanceService {
    BaseConnaissance creerBase(BaseConnaissance baseConnaissance);
    BaseConnaissance modifierBase(Long id,BaseConnaissance baseConnaissance);
    String supprimerBase(Long id);
    List<BaseConnaissance> listBase();

}
