package com.example.gest_ticket.securite;


import com.example.gest_ticket.modele.User;
import com.example.gest_ticket.repository.AdminRepository;
import com.example.gest_ticket.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailServices implements UserDetailsService {

    private final UserRepository userRepository;
    AdminRepository adminRepository;
    public UserDetails loadUserByUsername(String nom) throws UsernameNotFoundException {
        System.out.println("Hello1");
        User user = userRepository.findByNom(nom);
      //  System.out.println("Hello2");
        System.out.println(user.getNom());
        System.out.println(user.getPassword());
        System.out.println(user.getRole());

        return org.springframework.security.core.userdetails.User.
                withUsername(user.getNom()).
                password(user.getPassword()).
                roles(user.getRole()).
                build();

    }
}

/*private String[] adminRole(Admin admin) {
    return admin.split(",");
}*/