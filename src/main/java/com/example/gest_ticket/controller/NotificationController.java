package com.example.gest_ticket.controller;


import com.example.gest_ticket.modele.Formateur;
import com.example.gest_ticket.modele.Notification;
import com.example.gest_ticket.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
@AllArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;
    @PostMapping("/addnotification")
    public Notification creerNotification(@RequestBody Notification notification){
        return notificationService.creerNotification(notification);
    }
}
