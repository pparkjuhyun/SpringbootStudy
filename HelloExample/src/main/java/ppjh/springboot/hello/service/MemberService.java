package ppjh.springboot.hello.service;

import ppjh.springboot.hello.domain.Member;
import ppjh.springboot.hello.repository.MemberRepository;
import ppjh.springboot.hello.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

/**
 * implements Business Logic
 * naming must be business like
 */
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * join new member
     * @param member
     * @return
     */
    public Long join(Member member) {
        //if name is duplicated
        validateDuplicateMember(member);    //duplicated member validation
        memberRepository.save(member);
        return member.getId();
    }

    /**
    * validate input data
    * if member who has same name is exist, throw exception
    */
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("the name is already exist");
                });
    }

    /**
     * whole member list
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
