package com.example.web;

import com.example.web.domain.Member;
import com.example.web.domain.QMember;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void saveMember(Member member) {
        em.persist(member);
    }

    public Member findMember(Long memberId) {
        return em.find(Member.class, memberId);
    }

    public List<Member> findMemberList(Member member) {
        JPAQuery<?> query = new JPAQuery<Void>(em);
        QMember qM = QMember.member;
        return query.select(qM)
                .from(qM)
                .where(qM.name.containsIgnoreCase(member.getName())
                ).fetch();
    }
}