package com.sadwikapabba.module1.Impl;

import com.sadwikapabba.module1.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@Qualifier("smsNotif")
//@ConditionalOnProperty(name = "notification.type", havingValue="sms")

public class SmsNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("sms sending...."+message);
    }
}
