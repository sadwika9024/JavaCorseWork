package com.sadwikapabba.module1.Impl;

import com.sadwikapabba.module1.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("emailNotif")
//@ConditionalOnProperty(name = "notification.type", havingValue="email")
public class EmailNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Email sending..."+message);
    }
}
