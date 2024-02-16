package com.innowise.sivachenko.model.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotificationNotFoundException extends RuntimeException {
    public NotificationNotFoundException(String message) {
        super(message);
    }
}
