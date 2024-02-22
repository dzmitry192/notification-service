package com.innowise.sivachenko.service.api;

import com.innowise.sivachenko.kafka.avro.NotificationRequest;

public interface SendMailMessageService {
    void sendMailMessage(NotificationRequest notification);
}
