package com.example.gest_ticket.controller;

import com.example.gest_ticket.modele.Admin;
import com.example.gest_ticket.modele.Apprenant;
import com.example.gest_ticket.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
@Tag(name = "Administrateur", description = "Gestion d'admin")
public class AdminController {
    private final AdminService adminService;
    @Operation(description = "Ajouter un admin")
    @PostMapping("/addadmin")
    public Admin creerAdmin(@RequestBody Admin admin){
        return adminService.creerAdmin(admin);
    }
    @Operation(description = "Lire un admin")
    @GetMapping("/readadmin")
    public List<Admin> listerAdmin() {
        return adminService.listerAdmin();
    }
    @Operation(description = "mettre a jour l admin")
    @PutMapping("/updateadmin/{id}")
    public Admin modifierAdmin(@PathVariable Long id, @RequestBody Admin admin){
        return adminService.modifierAdmin(id,admin);
    }
    @Operation(description = "Supprimer un admin")
    @DeleteMapping("/deleteadmin/{id}")
    public String supprimerAdmin(@PathVariable Long id){
        return adminService.supprimerAdmin(id);
    }
}
