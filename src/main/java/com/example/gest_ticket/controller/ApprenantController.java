package com.example.gest_ticket.controller;

import com.example.gest_ticket.modele.Admin;
import com.example.gest_ticket.modele.Apprenant;
import com.example.gest_ticket.service.ApprenantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apprenant")
@AllArgsConstructor
@Tag(name = "Apprenant", description = "Gestion des apprenants")
public class ApprenantController {
    private final ApprenantService apprenantService;
    @Operation(description = "ajouter un apprenant")
    @PostMapping("/addapprenant")
    public Apprenant creerAdmin(@RequestBody Apprenant apprenant){
        return apprenantService.creerApprenant(apprenant);
    }
    @Operation(description = "Lire les apprenants")
    @GetMapping("/readapprenant")
    public List<Apprenant> listerAdmin() {
        return apprenantService.listerApprenant();
    }
    @Operation(description = "modifier un apprenant")
    @PutMapping("/updateapprenant/{id}")
    public Apprenant modifierApprenant(@PathVariable Long id, @RequestBody Apprenant apprenant){
        return apprenantService.modifierApprenant(id,apprenant);
    }
    @Operation(description = "supprimer un apprenant")
    @DeleteMapping("/deleteapprenant/{id}")
    public String supprimerApprenant(@PathVariable Long id){
        return apprenantService.supprimerApprenant(id);
    }
}
