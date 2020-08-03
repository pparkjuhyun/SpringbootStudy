package ppjh.springboot.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ppjh.springboot.hello.service.MemberService;

@Controller
public class MemberController {

    //field 주입
//    @Autowired private MemberService memberService;
    @Autowired private final MemberService memberService;

    //생성자 주입 -> best practice
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //setter 주입
//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }
}
