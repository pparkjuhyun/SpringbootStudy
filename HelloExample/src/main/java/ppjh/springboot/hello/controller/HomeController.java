package ppjh.springboot.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * 1. Spring container의 controller에 매핑된 url이 있나 확인
     * 2. 없으면 index.html 호출
     * @return
     */
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
