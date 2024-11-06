package com.duyargaaglari.proje.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendNotificationMail(String targetMail, String subject, String text) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");

            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(text);
            mimeMessageHelper.setTo(targetMail);

            mailSender.send(mimeMessage);
        } catch (MailSendException e) {
            System.out.println("ERROR  : " + e.getMessage());
            throw new MailSendException("failed to send notification mail", e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
