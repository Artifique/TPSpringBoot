package com.example.gest_ticket.controller;

import com.example.gest_ticket.modele.Admin;
import com.example.gest_ticket.modele.Apprenant;
import com.example.gest_ticket.modele.User;
import com.example.gest_ticket.service.AdminService;
import com.example.gest_ticket.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
//pour MMe
    @GetMapping("/user")
    public String getCurrentUser(Principal principal) {
        System.out.println("user connecté========"+principal.getName());
        return principal.getName();
    }
    @GetMapping("/user2")
    public String getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        System.out.println("user connecté========"+userDetails.getUsername());
        return userDetails.getUsername();
    }
    //fin pour MMe

    @PostMapping("/adduser")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping("/readuser")
    public List<User> listerUser() {
        return userService.listerUser();
    }
    @PutMapping("/updateuser/")
    public User modifyUser(@PathVariable Long id, @RequestBody User user){
        return userService.modifyUser(id,user);
    }
    @DeleteMapping("/deleteadmin/")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
