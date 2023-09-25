package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        // 데이터를 변경하는 모든 작업은 transaction 안에서 작업해야 함
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setName("member1");
            member.setTeam(team); //**
            em.persist(member);

//            team.getMembers().add(member); //연관관계 편의 메소드 있는 경우 주석
//
            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId()); //1차 캐시
            List<Member> members = findMember.getTeam().getMembers();

            System.out.println("==========");
            for (Member m : members) {
                System.out.println("m = " + m.getName());
            }
            System.out.println("==========");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
