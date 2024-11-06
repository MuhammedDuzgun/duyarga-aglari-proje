package com.duyargaaglari.proje.controller;

import com.duyargaaglari.proje.service.INotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    private final INotificationService notificationService;

    @GetMapping("/send-notification")
    public ResponseEntity<?> sendNotification() {
        notificationService.createNotification();
        return ResponseEntity.ok().build();
    }

}
