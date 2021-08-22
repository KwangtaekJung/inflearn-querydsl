package study.querydsl.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
@Commit
class MemberTest {

    @PersistenceContext
    EntityManager em;

    @Test
    void testEntity() {

        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        Member m1 = new Member("m1", 10, teamA);
        Member m2 = new Member("m2", 20, teamA);
        Member m3 = new Member("m3", 30, teamB);
        Member m4 = new Member("m4", 40, teamB);
        em.persist(m1);
        em.persist(m2);
        em.persist(m3);
        em.persist(m4);

        em.flush();
        em.clear();

        List<Member> members = em.createQuery("select m from Member m", Member.class)
                .getResultList();
        for (Member member : members) {
            System.out.println("member = " + member);
            System.out.println("--team = " + member.getTeam());
        }
    }
}