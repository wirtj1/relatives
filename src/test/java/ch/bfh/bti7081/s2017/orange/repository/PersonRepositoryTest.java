//package ch.bfh.bti7081.s2017.orange.repository;
//
//import ch.bfh.bti7081.s2017.orange.persistence.entity.Person;
//import ch.bfh.bti7081.s2017.orange.persistence.entity.Relative;
//import ch.bfh.bti7081.s2017.orange.persistence.repository.impl.PersonRepository;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * @author yvesbeutler
// * Unit tests for person repository.
// */
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class PersonRepositoryTest {
//
//    private PersonRepository example = new PersonRepository();
//
//    Person person1;
//    Person person2;
//
//    //Only to use with a test database
//    private void deleteAllFromTable()
//    {
////        em.createQuery("DELETE FROM User m")
////                .executeUpdate();
//    }
//
//    @Test
//    public void a_saveUser() throws Exception
//    {
//        System.out.println("After sucessful insertion ");
//
//        person1 = example.add(new Relative());
//        person2 = example.add(new Relative());
//
//        //assertEquals(2, example.get().size());
//
//
//        /*assertEquals(example.getUserById(user1.getUserId()),user1);
//        assertEquals(example.getUserById(user2.getUserId()),user2);*/
//    }
//
//   /* public void listTestObjects(List mainModels) throws Exception
//    {
//
//        mainModels.forEach(System.out::println);
//    }
//
//    @Test
//    public void c_updateUser() throws Exception
//    {
//
//        System.out.println("After Sucessfully modification ");
//        example.updateUser(user1.getUserId(), "Hans2");
//        example.updateUser(user2.getUserId(), "Ruedi2");
//
//        assertEquals(example.getUserById(user1.getUserId()).getUserName(),"Hans2");
//        assertEquals(example.getUserById(user2.getUserId()).getUserName(),"Ruedi2");
//
//    }
//
//    @Test
//    public void d_deleteUser() throws Exception
//    {
//        System.out.println("After Sucessfully deletion ");
//        example.deleteUser(user2.getUserId());
//
//        assertEquals(0, example.listUser().size());
//    }*/
//
//}
