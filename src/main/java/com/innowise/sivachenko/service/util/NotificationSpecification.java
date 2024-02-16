package com.innowise.sivachenko.service.util;

import com.innowise.sivachenko.model.entity.NotificationEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class NotificationSpecification {

    public static Specification<NotificationEntity> withEmail(String email) {
        return (notification, query, builder) -> email != null ? builder.equal(notification.get("email"), email) : null;
    }

    public static Specification<NotificationEntity> withSubject(String subject) {
        return (notification, query, builder) -> subject != null ? builder.equal(notification.get("subject"), subject) : null;
    }
}
