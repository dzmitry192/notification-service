package com.innowise.sivachenko.service;

import com.innowise.sivachenko.mapper.NotificationMapper;
import com.innowise.sivachenko.model.dto.response.NotificationDto;
import com.innowise.sivachenko.model.entity.NotificationEntity;
import com.innowise.sivachenko.model.exception.NotificationNotFoundException;
import com.innowise.sivachenko.repository.NotificationRepository;
import com.innowise.sivachenko.service.api.NotificationService;
import com.innowise.sivachenko.service.util.NotificationSpecification;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public Page<NotificationDto> getNotifications(String email, String subject, Pageable pageable) {
        Specification<NotificationEntity> specification = Specification.where(
                NotificationSpecification.withEmail(email)
                        .and(NotificationSpecification.withSubject(subject)));
        return notificationRepository.findAll(specification, pageable).map(NotificationMapper.INSTANCE::notificationEntityToNotificationDto);
    }

    @Override
    @SneakyThrows
    public NotificationDto getNotificationById(Long notificationId) {
        Optional<NotificationEntity> optionalNotification = notificationRepository.findById(notificationId);
        if (optionalNotification.isPresent()) {
            log.info("Notification with id {} was found", notificationId);
            return NotificationMapper.INSTANCE.notificationEntityToNotificationDto(optionalNotification.get());
        } else {
            log.info("Notification with id {} not found", notificationId);
            throw new NotificationNotFoundException("Notification with id = " + notificationId + " not found");
        }
    }
}
