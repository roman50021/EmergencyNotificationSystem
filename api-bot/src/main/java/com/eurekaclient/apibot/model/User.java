package com.eurekaclient.apibot.model;

import com.eurekaclient.apibot.model.contract.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bot_users")
public class User extends AbstractEntity {

    @Column(name = "chat_id", unique = true, nullable = false)
    private Long chatId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Enumerated(EnumType.STRING)
    Action action;

    @Column(name = "registered_at", nullable = false)
    private LocalDateTime registeredAt;

    @OneToMany
    private Set<EmergencyNotification> notifications;

    @Column(name = "current_notification_id")
    UUID currentNotification;

}
