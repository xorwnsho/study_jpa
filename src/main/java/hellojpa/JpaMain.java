package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // 영속
            Member member1 = new Member(1000L, "오준택");
            Member member2 = new Member(1001L, "오준택2");

            // 버퍼링 효과 사용 -> 한 번에 DB에 커밋
            em.persist(member1);
            em.persist(member2);


            System.out.println("==================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();

        }
        emf.close();
    }
}
