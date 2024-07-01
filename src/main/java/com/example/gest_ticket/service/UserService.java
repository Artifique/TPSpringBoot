package com.example.gest_ticket.service;

import com.example.gest_ticket.modele.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> listerUser();
    User modifyUser(Long id,User user);
    String deleteUser(Long id);
}
