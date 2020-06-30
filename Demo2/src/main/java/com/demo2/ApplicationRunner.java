package com.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.boot.ApplicationRunner;

/**
 * Application이 실행된 후 추가적인 작업이 필요하다면 사용
 * Runner가 여러개면 @Ordered Annotation 사용 
 */

@Component
class AppRunner implements ApplicationRunner {

    @Autowired
    private String hello;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("==========================");
        System.out.println(hello);
        System.out.println("==========================");
    }
}
