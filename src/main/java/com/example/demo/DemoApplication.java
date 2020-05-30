package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@PropertySource("classpath:/app.properties")
@EnableAsync
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("classpath:/messages");
//        messageSource.setDefaultEncoding("UTF-8");
//        messageSource.setCacheSeconds(3);
//        return messageSource;
//    }
}
