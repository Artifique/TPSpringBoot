package com.example.gest_ticket.controller;

import com.example.gest_ticket.modele.Admin;
import com.example.gest_ticket.modele.Apprenant;
import com.example.gest_ticket.modele.BaseConnaissance;
import com.example.gest_ticket.service.ApprenantService;
import com.example.gest_ticket.service.BaseConnaissanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/base")
@AllArgsConstructor
@Tag(name = "Base de Connaissance", description = "Gestion de la base de connaissance")
public class BaseController {
    private final BaseConnaissanceService baseConnaissanceService;
    @Operation(description = "ajouter une ")
    @PostMapping("/addbase")
    public BaseConnaissance creerBase (@RequestBody BaseConnaissance baseConnaissance){
        return baseConnaissanceService.creerBase(baseConnaissance);
    }
    @GetMapping("/readbase")
    public List<BaseConnaissance> listBase() {
        return baseConnaissanceService.listBase();
    }
    @PutMapping("/updatebase/{id}")
    public BaseConnaissance modifierBase(@PathVariable Long id, @RequestBody BaseConnaissance baseConnaissance){
        return baseConnaissanceService.modifierBase(id,baseConnaissance);
    }
    @DeleteMapping("/deletebase/{id}")
    public String supprimerBase(@PathVariable Long id){
        return baseConnaissanceService.supprimerBase(id);
    }
}
