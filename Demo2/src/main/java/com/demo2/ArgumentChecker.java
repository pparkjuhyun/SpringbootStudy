package com.demo2;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

/**
 * 1.어떤 Bean의 생성자가 1개이고
 * 2.그 Bean의 생성자의 Argument가 등륵된 Bean 일경우 
 * 
 * Spring이 알아서 DI 해줌
 * VMOptions 이 아닌 (VMOptions는 못받음)
 * Program Argument로 들어온 args를 넘겨줌
 */
@Component
public class ArgumentChecker {

    
    public ArgumentChecker(ApplicationArguments args) {
        System.out.println("foo: " + args.containsOption("foo"));
        System.out.println("bar: " + args.containsOption("bar"));
    }
}
