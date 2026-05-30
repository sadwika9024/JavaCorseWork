package com.sadwikapabba.module1;

import com.sadwikapabba.module1.Impl.SmsNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Module1Application implements CommandLineRunner {
//field injuction when we use aoutowired
//	@Autowired
//NotificationService notificationService;

	//constructor based
//	final NotificationService notificationService;

	//constructor based with qualifier
//	Module1Application(@Qualifier("smsNotif") NotificationService notificationService){
//		this.notificationService = notificationService;
//	}

	//constructor based without qualifier
//	Module1Application(NotificationService notificationService){
//		this.notificationService = notificationService;
//	}


	//send notification to all the services
	@Autowired
	Map<String ,NotificationService> allBeanServices = new HashMap<>();
	public static void main(String[] args) {
		SpringApplication.run(Module1Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
//		NotificationService notificationService = new SmsNotificationService();

		for (var notificationService : allBeanServices.entrySet()) {

			System.out.println("key : " + notificationService.getKey());
			notificationService.getValue().send("Hello");

		}

	}
}
