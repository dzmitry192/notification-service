package com.innowise.notificationservice.service.api;

import com.innowise.notificationservice.model.dto.NotificationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NotificationService {
    Page<NotificationDto> getNotifications(String email, String subject, Pageable pageable);
    NotificationDto getNotificationById(Long notificationId);
}
