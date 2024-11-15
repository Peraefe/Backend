package com.appkero.backend_kero.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender mailSender;

    public void sendPasswordResetEmail(String email, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@mail.com");
        message.setTo(email);
        message.setSubject("Email de Recuperação de Senha");
        message.setText("Utilize o link a seguir para recuperar seu acesso: http://localhost:8080/api/auth/reset-password?token="+token);
        mailSender.send(message);
    }

}
