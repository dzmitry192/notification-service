package com.innowise.sivachenko.service;

import com.innowise.sivachenko.model.dto.NotificationDto;
import com.innowise.sivachenko.repository.NotificationRepository;
import com.innowise.sivachenko.service.api.NotificationService;
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
