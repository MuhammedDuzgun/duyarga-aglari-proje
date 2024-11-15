package com.duyargaaglari.proje.controller;

import com.duyargaaglari.proje.service.INotificationService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
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
    @RateLimiter(name = "general_limiter")
    public ResponseEntity<?> sendNotification() {
        notificationService.createNotification();
        return ResponseEntity.ok().build();
    }

}
