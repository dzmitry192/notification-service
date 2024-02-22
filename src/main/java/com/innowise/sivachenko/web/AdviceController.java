package com.innowise.sivachenko.web;

import com.innowise.sivachenko.model.dto.error.ExceptionErrorDto;
import com.innowise.sivachenko.model.exception.NotificationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {
    /**
     * 404
     */
    @ExceptionHandler(NotificationNotFoundException.class)
    public ResponseEntity<ExceptionErrorDto> notificationNotFoundHandler(NotificationNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionErrorDto(exception.getMessage()));
    }

    /**
     * 500
     */
    @ExceptionHandler
    public ResponseEntity<ExceptionErrorDto> handler(Throwable e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ExceptionErrorDto(e.getMessage()));
    }
}
