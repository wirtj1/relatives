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

        em.persist(mov);
        em.getTransaction().commit();

        System.out.println("ID: " + mov.getId());

        em.close();
        ef.close();
    }
}
