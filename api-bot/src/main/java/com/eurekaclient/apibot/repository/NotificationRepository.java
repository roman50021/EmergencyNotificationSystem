package com.eurekaclient.apibot.repository;

import com.eurekaclient.apibot.model.EmergencyNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NotificationRepository extends JpaRepository<EmergencyNotification, UUID> {
}
