package com.spring.app.services.impl;

import com.spring.app.services.IEmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@AllArgsConstructor
@Service
@Transactional
public class EmailServiceImpl implements IEmailService {

        //Importante hacer la inyección de dependencia de JavaMailSender:
        @Autowired
        private JavaMailSender mailSender;

        @Override
        public void sendEmail(String to, String subject, String content) {

            SimpleMailMessage email = new SimpleMailMessage();

            email.setTo(to);
            email.setSubject(subject);
            email.setText(content);

            mailSender.send(email);
        }
}


