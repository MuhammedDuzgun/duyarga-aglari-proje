package com.duyargaaglari.proje.repository;

import com.duyargaaglari.proje.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotificationRepository extends JpaRepository<Notification, Long> {
}
