package com.duyargaaglari.proje.service.impl;

import com.duyargaaglari.proje.entity.Notification;
import com.duyargaaglari.proje.repository.INotificationRepository;
import com.duyargaaglari.proje.service.EmailService;
import com.duyargaaglari.proje.service.INotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificationService implements INotificationService {

    private final INotificationRepository notificationRepository;
    private final EmailService emailService;

    @Override
    public void createNotification() {
        Notification notification = new Notification();
        notification.setBody("Gaz Algılandı");
        Notification savedNotification = notificationRepository.save(notification);

        //send mail
        String targetMail = "muhammedduzgun00@gmail.com";
        String subject = "Gaz Dedektoru Bilgilendirme";
        String text = savedNotification.getBody() + "\n" + " Tarih Bilgileri : " + savedNotification.getCreationDateTime();
        emailService.sendNotificationMail(targetMail, subject, text);
    }
}
