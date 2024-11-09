package com.duyargaaglari.proje.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NotificationServiceTest {

    @Autowired
    INotificationService notificationService;

    @Test
    public void createNotificationTest() {
        notificationService.createNotification();
    }

}
