package com.innowise.sivachenko.web.controller;

import com.innowise.sivachenko.model.dto.response.NotificationDto;
import com.innowise.sivachenko.service.NotificationServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/api/v1/notification-service")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationServiceImpl notificationService;

    @GetMapping("/")
    public ResponseEntity<Page<NotificationDto>> getNotifications(
            @RequestParam(name = "email", required = false) String email,
            @RequestParam(name = "subject", required = false) String subject,
            Pageable pageable
    ) {
        return ResponseEntity.ok().body(notificationService.getNotifications(email, subject, pageable));
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<NotificationDto> getNotificationById(@PathVariable Long notificationId) {
        return ResponseEntity.ok().body(notificationService.getNotificationById(notificationId));
    }
}
