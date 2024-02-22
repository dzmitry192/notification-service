package com.innowise.sivachenko.kafka.listener;

import com.innowise.sivachenko.kafka.avro.NotificationRequest;
import com.innowise.sivachenko.service.SendMailMessageServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class KafkaListeners {

    private final SendMailMessageServiceImpl sendMailMessageService;

    @KafkaListener(topics = "${kafka.topic.client-service-notification-topic}", groupId = "client-service-notification-topic", containerFactory = "listenerContainerFactory")
    public void clientServiceNotificationListener(NotificationRequest notificationRequest) {
       log.info("new notification request from client service in {}", notificationRequest.getCreatedAt());
       sendMailMessageService.sendMailMessage(notificationRequest);
    }

    @KafkaListener(topics = "${kafka.topic.rent-service-notification-topic}", groupId = "rent-service-notification-topic", containerFactory = "listenerContainerFactory")
    public void rentServiceNotificationListener(NotificationRequest notificationRequest) {
        log.info("new notification request from rent service in {}", notificationRequest.getCreatedAt());
        sendMailMessageService.sendMailMessage(notificationRequest);
    }

    @KafkaListener(topics = "${kafka.topic.payment-service-notification-topic}", groupId = "payment-service-notification-topic", containerFactory = "listenerContainerFactory")
    public void paymentServiceNotificationListener(NotificationRequest notificationRequest) {
        log.info("new notification request from payment service in {}", notificationRequest.getCreatedAt());
        sendMailMessageService.sendMailMessage(notificationRequest);
    }
}
