package com.example.gest_ticket.service.Implementation;

import com.example.gest_ticket.modele.Notification;
import com.example.gest_ticket.modele.Ticket;
import com.example.gest_ticket.repository.NotificationRepository;
import com.example.gest_ticket.service.NotificationService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public Notification creerNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    /*public void envoyerNotification(Ticket ticket, String message) {
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setTicket(ticket);
        notification.setApprenant(ticket.getApprenant());

        // Save the notification in the database
        notificationRepository.save(notification);

        // Send the email notification
        sendEmailNotification(ticket.getApprenant().getEmail(), message);
    }

    private void sendEmailNotification(String mail, String message) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(mail);
            helper.setSubject("Nouvelle Notification de Ticket");
            helper.setText(message, true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }*/
}
