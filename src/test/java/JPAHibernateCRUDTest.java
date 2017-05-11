import ch.bfh.bti7081.s2017.orange.businesslogic.models.Doctor;
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
        em.persist(new Doctor());
        em.getTransaction().commit();
        em.close();
        ef.close();
    }

}
