package com.innowise.sivachenko.model.dto.response;

import lombok.Builder;

import java.time.Instant;

@Builder
public record NotificationDto(
        Long id,
        String email,
        String subject,
        String body,
        Instant createdAt
) {
}
