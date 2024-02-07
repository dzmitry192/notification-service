package com.innowise.notificationservice.service;

import com.innowise.notificationservice.model.dto.NotificationDto;
import com.innowise.notificationservice.repository.NotificationRepository;
import com.innowise.notificationservice.service.api.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public Page<NotificationDto> getNotifications(String email, String subject, Pageable pageable) {
        return null;
    }

    @Override
    public NotificationDto getNotificationById(Long notificationId) {
        return null;
    }
}
