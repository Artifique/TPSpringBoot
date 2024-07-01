package com.example.gest_ticket.controller;

import com.example.gest_ticket.modele.Admin;

import com.example.gest_ticket.modele.Formateur;
import com.example.gest_ticket.service.FormateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formateur")
@AllArgsConstructor
public class FormateurController {
    private final FormateurService formateurService;
    @PostMapping("/addformateur")
    public Formateur creerFormateur(@RequestBody Formateur formateur){
        return formateurService.creerFormateur(formateur);
    }
    @GetMapping("/readformateur")
    public List<Formateur> listerFormateur() {
        return formateurService.listerFormateur();
    }
    @PutMapping("/updateformateur/{id}")
    public Formateur modifierFormateur(@PathVariable Long id, @RequestBody Formateur formateur){
        return formateurService.modifierFormateur(id,formateur);
    }
    @DeleteMapping("/deleteformateur/{id}")
    public String supprimerFormateur(@PathVariable Long id){
        return formateurService.supprimerFormateur(id);
    }
}
