package ppjh.sb.example.mvc.user;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/hello")
    public @ResponseBody String hello() {   //RestController일 때, ResponseBody는 생략 가능
        return "hello";
    }

//    @PostMapping("/user")
//    public @ResponseBody User create(@RequestBody User user) {
//        return null;
//    }

    @PostMapping("/user/create")
    public User create(@RequestBody User user) {
        return user;
    }
}
