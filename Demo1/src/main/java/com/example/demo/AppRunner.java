package com.example.demo;

import com.example.demo.event.LatestStyleEvent;
import com.example.demo.event.MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.nio.file.Files;

@Component
public class AppRunner implements ApplicationRunner {
    @Autowired
    ApplicationContext ctx;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    MessageSource messageSource;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    ApplicationEventPublisher publisher;

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Environment environment = ctx.getEnvironment();
//        System.out.println(environment.getProperty("app.name"));

//        while(true) {
//            System.out.println(messageSource.getMessage("greeting", new String[]{"juhyun"}, Locale.KOREA));
//            System.out.println(messageSource.getMessage("greeting", new String[]{"juhyun"}, Locale.getDefault()));
//            Thread.sleep(2000l);
//        }

//        publisher.publishEvent(new MyEvent(this, 100));
//        publisher.publishEvent(new LatestStyleEvent(this, 500));
        Resource resource = resourceLoader.getResource("classpath:text.txt");
        System.out.println(resource.exists());
        System.out.println(resource.getDescription());
    }
}
