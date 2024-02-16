package com.innowise.sivachenko.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notifications")
@Entity
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Email
    @Column(name = "email")
    private String email;
    @NotBlank
    @Column(name = "subject")
    private String subject;
    @NotBlank
    @Column(name = "message")
    private String message;
    @NotNull
    @Column(name = "createdAt")
    private Instant createdAt;

}
