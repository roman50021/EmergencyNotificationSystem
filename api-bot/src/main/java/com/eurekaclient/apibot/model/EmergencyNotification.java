package com.eurekaclient.apibot.model;

import com.eurekaclient.apibot.model.contract.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notifications")
public class EmergencyNotification extends AbstractEntity {
    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @Enumerated(EnumType.STRING)
    Status status;

    //todo Связь на получателей

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
