package com.example.gest_ticket.service.Implementation;

import com.example.gest_ticket.modele.User;
import com.example.gest_ticket.repository.UserRepository;
import com.example.gest_ticket.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> listerUser() {
        return userRepository.findAll();
    }

    @Override
    public User modifyUser(Long id, User user) {
        return userRepository.findById(id)
                .map((user1) ->{
                    user.setId(user1.getId());
                    user.setNom(user.getNom());
                    user.setEmail(user.getEmail());
                    user.setPassword(user.getPassword());
                    user.setRole(user.getRole());
                    return userRepository.save(user);
                }).orElseThrow(() -> new RuntimeException("User non trouvé"));
    }

    @Override
    public String deleteUser(Long id) {
   userRepository.deleteById(id);
   return "User Supprimé";
    }
}
