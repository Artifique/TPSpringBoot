package com.example.gest_ticket.controller;

import com.example.gest_ticket.modele.CategorieTicket;
import com.example.gest_ticket.service.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
@AllArgsConstructor
public class CategorieController {
    private final CategorieService categorieService;
    @PostMapping("/addcategorie")
    public CategorieTicket creerCategorie(@RequestBody CategorieTicket categorieTicket){
        return categorieService.creerCategorie(categorieTicket);
    }
    @GetMapping("/readcategorie")
    public List<CategorieTicket> listerCategorie() {
        return categorieService.listerCategorie();
    }
    @PutMapping("/updatecategorie/{id}")
    public CategorieTicket modifierCategorie(@PathVariable Long id, @RequestBody CategorieTicket categorieTicket){
        return categorieService.modifierCategorie(id,categorieTicket);
    }
    @DeleteMapping("/deletecategorie/{id}")
    public String supprimerCategorie(@PathVariable Long id){
        return categorieService.supprimerCategorie(id);
    }
}
