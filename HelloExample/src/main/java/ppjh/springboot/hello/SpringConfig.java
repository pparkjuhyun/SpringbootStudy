package ppjh.springboot.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ppjh.springboot.hello.repository.MemberRepository;
import ppjh.springboot.hello.repository.MemoryMemberRepository;
import ppjh.springboot.hello.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
