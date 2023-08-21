package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] arge) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        // 데이터를 변경하는 모든 작업은 transaction 안에서 작업해야 함
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // Create
//            Member member = new Member();
//            member.setId(3L);
//            member.setName("HelloC");
//
//            em.persist(member);

            // Read
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//
//            // Update
//            findMember.setName("HelloKK");

            // Delete
//            em.remove(findMember);


            // JPQL
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();

            for (Member member: result) {
                System.out.println("member.name = " + member.getName());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
