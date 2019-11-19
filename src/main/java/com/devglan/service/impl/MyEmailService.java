package com.devglan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MyEmailService  {
@Autowired
private JavaMailSender javaMailSender;
public void sendOtpMessage(String to, String subject, String message) {
 SimpleMailMessage simpleMailMessage = new SimpleMailMessage(); 
 simpleMailMessage.setTo(to); 
 simpleMailMessage.setSubject(subject); 
 simpleMailMessage.setText(message);
 System.out.println(subject);
 System.out.println(to);
 System.out.println(message);
 javaMailSender.send(simpleMailMessage);
}
}