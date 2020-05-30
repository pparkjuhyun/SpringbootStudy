package com.example.demo.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("event receive. data is " + event.getData());
    }
}
