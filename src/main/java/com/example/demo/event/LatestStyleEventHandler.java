package com.example.demo.event;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class LatestStyleEventHandler {

    @EventListener
//    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Async
    public void handle(LatestStyleEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("latest style event. data is " + event.getData());
    }
    @EventListener
//    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Async
    public void handle(ContextClosedEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("ContextClosedEvent");
    }
}
