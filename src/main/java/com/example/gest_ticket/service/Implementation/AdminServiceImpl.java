package com.example.gest_ticket.service.Implementation;

import com.example.gest_ticket.modele.Admin;
import com.example.gest_ticket.repository.AdminRepository;
import com.example.gest_ticket.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    @Autowired
    private final AdminRepository adminRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Admin creerAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }


    @Override
    public List<Admin> listerAdmin() {
        return adminRepository.findAll();
    }
    @Override
    public Admin modifierAdmin(Long id, Admin admin) {
        return adminRepository.findById(id)
                .map(admin1->{
                    admin1.setNom(admin.getNom());
                    admin1.setEmail(admin.getEmail());
                    return adminRepository.save(admin1);

                }).orElseThrow(()-> new RuntimeException("Admin non trouvé"));

    }
    @Override
    public String supprimerAdmin(Long id) {
         adminRepository.deleteById(id);
         return "Admin Supprimé avec succès!!";
    }

}
