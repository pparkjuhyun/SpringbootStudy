package ppjh.springboot.hello.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import ppjh.springboot.hello.domain.Member;
import ppjh.springboot.hello.repository.MemberRepository;
import ppjh.springboot.hello.repository.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest //스프링 컨테이너가 테스트와 함께 실행됨
@Transactional  //트랜잭션이 끝날때 마다 트랜잭션을 롤백해줌
class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Commit
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");
        
        //when
        Long saveId = memberService.join(member);
        
        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void join_dupl_exception() {
        //given
        Member member = new Member();
        member.setName("spring");

        Member member1 = new Member();
        member1.setName("spring");

        //when
        memberService.join(member);
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> memberService.join(member1));
        Assertions.assertThat(illegalStateException.getMessage()).isEqualTo("the name is already exist");

//        try {
//            memberService.join(member1);
//            fail();
//        } catch (IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("the name is already exist");
//        }
        //then
    }
}