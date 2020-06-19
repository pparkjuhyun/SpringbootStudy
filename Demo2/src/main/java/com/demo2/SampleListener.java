package com.demo2;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * ApplicationListener를 사용할 땐 ApplicationContext의 생성 전/후에 따라 적절한 코딩 필요
 * Application Context 생성 전: Bean 사용 불가 -> Application에 Listener 직접 등록 필요 -> @Bean등록 할필요 없으며 해도 안됨
 */

//@Component
public class SampleListener implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        System.out.println("=======================");
        System.out.println("Application is starting");
        System.out.println("=======================");
    }
}
