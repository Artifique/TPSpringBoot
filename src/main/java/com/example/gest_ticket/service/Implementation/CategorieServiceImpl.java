package com.example.gest_ticket.service.Implementation;

import com.example.gest_ticket.modele.CategorieTicket;
import com.example.gest_ticket.repository.CategorieRepository;
import com.example.gest_ticket.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategorieServiceImpl implements CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;
    @Override
    public CategorieTicket creerCategorie(CategorieTicket categorieTicket) {
        return categorieRepository.save(categorieTicket);
    }

    @Override
    public List<CategorieTicket> listerCategorie() {
        return categorieRepository.findAll();
    }

    @Override
    public CategorieTicket modifierCategorie(Long id, CategorieTicket categorieTicket) {
        return categorieRepository.findById(id)
                .map(categorieTicket1 -> {
                    categorieTicket1.setTitre(categorieTicket.getTitre());
                    return categorieRepository.save(categorieTicket1);
                }).orElseThrow(()-> new RuntimeException("La categorie n'existe pas"));
    }

    @Override
    public String supprimerCategorie(Long id) {
        categorieRepository.deleteById(id);
        return "Categorie supprimée avec succès!!!";
    }
}
