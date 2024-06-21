package com.eurekabegin.eurekaclient.model;

import com.eurekabegin.eurekaclient.model.contract.AbstractEntity;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
