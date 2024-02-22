package com.innowise.sivachenko.service;

import com.innowise.sivachenko.kafka.avro.NotificationRequest;
import com.innowise.sivachenko.model.entity.NotificationEntity;
import com.innowise.sivachenko.service.api.SendMailMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class SendMailMessageServiceImpl implements SendMailMessageService {

    private final JavaMailSender javaMailSender;

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    @Override
    public void sendMailMessage(NotificationRequest notificationRequest) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(notificationRequest.getEmail());
        message.setSubject(notificationRequest.getSubject());
        message.setText(notificationRequest.getMessage());
        message.setFrom(emailFrom);

        try {
            javaMailSender.send(message);
            log.info("Message was successfully sent to user with email: {}", notificationRequest.getEmail());
        } catch (MailException e) {
            log.info("Problem with sending message, exception: {}", e.getMessage());
        }
    }
}
