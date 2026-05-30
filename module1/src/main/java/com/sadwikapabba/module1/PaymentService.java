package com.sadwikapabba.module1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    public void pay(){
        System.out.println("paying.....to this class");
    }

    @PostConstruct
    public void afterInit(){
        System.out.println("after Initialization.....");

    }

    @PreDestroy
    public void beforeDestroy(){
        System.out.println("before Destroying..........");
    }
}
