package com.example.gest_ticket.service.Implementation;

import com.example.gest_ticket.modele.Apprenant;
import com.example.gest_ticket.repository.ApprenantRepository;
import com.example.gest_ticket.service.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprenantServiceImpl implements ApprenantService {
   @Autowired
   private ApprenantRepository apprenantRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Apprenant creerApprenant(Apprenant apprenant) {
        apprenant.setPassword(passwordEncoder.encode(apprenant.getPassword()));
        return apprenantRepository.save(apprenant);
    }

    @Override
    public Apprenant modifierApprenant(Long id, Apprenant apprenant) {
        return apprenantRepository.findById(id)
                .map(apprenant1 -> {
                    apprenant1.setAdmin(apprenant.getAdmin());
                    apprenant1.setNom(apprenant.getNom());
                    apprenant1.setEmail(apprenant.getEmail());
                    return apprenantRepository.save(apprenant1);
                }).orElseThrow(()-> new RuntimeException("Admin non trouvé"));

    }

    @Override
    public List<Apprenant> listerApprenant() {
        return apprenantRepository.findAll();
    }

    @Override
    public String supprimerApprenant(Long id) {
        apprenantRepository.deleteById(id);
        return "Apprenant supprimé avec succès !!!";
    }
}
