package com.example.gest_ticket.service.Implementation;

import com.example.gest_ticket.modele.Formateur;
import com.example.gest_ticket.repository.FormateurRepository;
import com.example.gest_ticket.service.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormateurServiceImpl implements FormateurService {
    @Autowired
    private FormateurRepository formateurRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Formateur creerFormateur(Formateur formateur) {
        formateur.setPassword(passwordEncoder.encode(formateur.getPassword()));
        return formateurRepository.save(formateur);
    }

    @Override
    public List<Formateur> listerFormateur() {
        return formateurRepository.findAll();
    }

    @Override
    public Formateur modifierFormateur(Long id, Formateur formateur) {
        return formateurRepository.findById(id)
                .map(formateur1 -> {
                    formateur1.setNom(formateur.getNom());
                    formateur1.setEmail(formateur.getEmail());
                    return formateurRepository.save(formateur1);
                }).orElseThrow(()-> new RuntimeException("Le formateur n'existe pas"));
    }

    @Override
    public String supprimerFormateur(Long id) {
        formateurRepository.deleteById(id);
        return "Formateur Supprimé avec succès!!";
    }
}
