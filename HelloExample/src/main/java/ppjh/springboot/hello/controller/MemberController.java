package ppjh.springboot.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ppjh.springboot.hello.domain.Member;
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

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }
}
