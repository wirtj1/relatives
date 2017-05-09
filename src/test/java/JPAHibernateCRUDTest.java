import ch.bfh.bti7081.s2017.orange.businesslogic.models.MainModel;
import ch.bfh.bti7081.s2017.orange.businesslogic.models.persistence.JPAHibernateCrud;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jasmin on 07.05.2017.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JPAHibernateCRUDTest
{

    private JPAHibernateCrud example = new JPAHibernateCrud();

    MainModel user1;
    MainModel user2;


    //Only to use with a test database
    private void deleteAllFromTable()
    {
//        em.createQuery("DELETE FROM User m")
//                .executeUpdate();
    }


    @Test
    public void a_saveUser() throws Exception
    {
        System.out.println("After sucessful insertion ");

        user1 = example.saveUser("Hans");
        user2 = example.saveUser("Ruedi");

        assertEquals(2, example.listUser().size());
        assertEquals(example.getUserById(user1.getUserId()),user1);
        assertEquals(example.getUserById(user2.getUserId()),user2);
    }


    public void listTestObjects(List mainModels) throws Exception
    {

        mainModels.forEach(System.out::println);
    }

    @Test
    public void c_updateUser() throws Exception
    {

        System.out.println("After Sucessfully modification ");
        example.updateUser(user1.getUserId(), "Hans2");
        example.updateUser(user2.getUserId(), "Ruedi2");

        assertEquals(example.getUserById(user1.getUserId()).getUserName(),"Hans2");
        assertEquals(example.getUserById(user2.getUserId()).getUserName(),"Ruedi2");

    }

    @Test
    public void d_deleteUser() throws Exception
    {
        System.out.println("After Sucessfully deletion ");
        example.deleteUser(user2.getUserId());

        assertEquals(0, example.listUser().size());
    }



}
