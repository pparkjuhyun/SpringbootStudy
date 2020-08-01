package ppjh.springboot.hello.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ppjh.springboot.hello.domain.Member;
import ppjh.springboot.hello.repository.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
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


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}