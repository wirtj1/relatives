import ch.bfh.bti7081.s2017.orange.persistence.entity.Movement;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Relative;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Jasmin on 07.05.2017.
 */
public class JPAHibernateCRUDTest {

    @Test
    public void persistPersonDoctor() throws Exception {
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("orange");
        EntityManager em = ef.createEntityManager();
        em.getTransaction().begin();

        Movement mov = new Movement();

        Relative rel = new Relative();
        rel.setFirstName("John");
        rel.setLastName("Smith");
        em.persist(rel);

        EntityManager em2 = ef.createEntityManager();
        em2.getTransaction().begin();

        Relative badRelative = new Relative();
        badRelative.setFirstName("bad insert");
        badRelative.setLastName("gugus");
        em2.persist(badRelative);
        em2.getTransaction().commit();

        em.persist(mov);
        em.getTransaction().commit();

        System.out.println("ID: " + mov.getId());

        Movement mov2 = em.find(Movement.class, 1L);
        System.out.println();
        System.out.println("Mov2: " + mov2);

        em.close();
        ef.close();
    }
}
