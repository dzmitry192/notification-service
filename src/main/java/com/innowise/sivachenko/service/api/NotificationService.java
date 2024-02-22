package com.innowise.sivachenko.service.api;

import com.innowise.sivachenko.model.dto.response.NotificationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NotificationService {
    Page<NotificationDto> getNotifications(String email, String subject, Pageable pageable);
    NotificationDto getNotificationById(Long notificationId);
}
