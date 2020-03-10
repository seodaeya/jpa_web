package com.example.web;

import com.example.web.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void memberList() {
        //given
        Member member = new Member("회원1");
        memberRepository.saveMember(member);

        //when
        List<Member> members = memberRepository.findMemberList(member);
        Member findMember1 = members.get(0);

        //then
        Assertions.assertThat(findMember1).isEqualTo(member);
    }
}