package ppjh.springboot.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ppjh.springboot.hello.aop.TimeTraceAop;
import ppjh.springboot.hello.repository.JdbcMemberRepository;
import ppjh.springboot.hello.repository.JpaMemberRepository;
import ppjh.springboot.hello.repository.MemberRepository;
import ppjh.springboot.hello.repository.MemoryMemberRepository;
import ppjh.springboot.hello.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
}
