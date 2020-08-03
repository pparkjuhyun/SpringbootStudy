package ppjh.springboot.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ppjh.springboot.hello.repository.JdbcMemberRepository;
import ppjh.springboot.hello.repository.MemberRepository;
import ppjh.springboot.hello.repository.MemoryMemberRepository;
import ppjh.springboot.hello.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();  //interface 구현을 통한 간단한 DB교체 예시
        return new JdbcMemberRepository(dataSource);
    }
}
