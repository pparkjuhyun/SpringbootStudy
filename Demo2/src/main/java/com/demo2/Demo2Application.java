package com.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo2Application {

    public static void main(String[] args) {
        //Application Customizing을 위한 Application instance 생성을 통한 Spring 실행 방법1
        SpringApplication app = new SpringApplication(Demo2Application.class);
        app.addListeners(new SampleListener());
//        app.setBannerMode(Mode.OFF);
        app.setWebApplicationType(WebApplicationType.NONE);  //MVC인 경우 SERVELET이 디폴트
                                                                //WEBFLUX가 있으면 REACTIVE
                                                                //둘 다 없으면 NONE
        app.run(args);

        //Application Customizing을 위한 Application instance 생성을 통한 Spring 실행 방법2
//        new SpringApplicationBuilder()
//                .sources(Demo2Application.class)
//                .run(args);
    }

}
