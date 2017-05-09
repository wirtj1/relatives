import ch.bfh.bti7081.s2017.orange.businesslogic.models.Doctor;
import ch.bfh.bti7081.s2017.orange.businesslogic.models.MainModel;
import ch.bfh.bti7081.s2017.orange.businesslogic.models.persistence.JPAHibernateCrud;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.Type;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jasmin on 07.05.2017.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JPAHibernateCRUDTest
{

    @Test
    public void boris() throws Exception
    {
        EntityManagerFactory ef =  Persistence.createEntityManagerFactory("orange");
        EntityManager em = ef.createEntityManager();
        em.getTransaction().begin();
        em.persist(new Doctor());
        em.getTransaction().commit();
        em.close();
        ef.close();
    }

}
