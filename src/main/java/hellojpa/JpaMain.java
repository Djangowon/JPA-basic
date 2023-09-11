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

            Member member1 = new Member();
            member1.setUsername("도원");

            Member member2 = new Member();
            member2.setUsername("인중");

            Member member3 = new Member();
            member3.setUsername("수정");

            Member member4 = new Member();
            member4.setUsername("태윤");

            Member member5 = new Member();
            member5.setUsername("길연");

            System.out.println("======");

            em.persist(member1);
            em.persist(member2);
            em.persist(member3);
            em.persist(member4);
            em.persist(member5);

            System.out.println("member1.id = " + member1.getId());
            System.out.println("member2.id = " + member2.getId());
            System.out.println("member3.id = " + member3.getId());
            System.out.println("member4.id = " + member4.getId());
            System.out.println("member5.id = " + member5.getId());

            System.out.println("======");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
