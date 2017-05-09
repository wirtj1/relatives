package ch.bfh.bti7081.s2017.orange.businesslogic.models.persistence;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.MainModel;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jasmin on 07.05.2017.
 */
public class JPAHibernateCrud
{

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();


    public MainModel saveUser(String userName)
    {
        MainModel user = new MainModel();
        try
        {
            transactionBegin();

            user.setUserName(userName);
            user = entityManager.merge(user);

            transactionCommit();

        } catch (Exception e)
        {
            transactionRollback();
        }
        return user;
    }


    public List<MainModel> listUser()
    {
        List<MainModel> userlList = new ArrayList<>();
        try
        {
            transactionBegin();

            userlList =
                    entityManager.createQuery("from USER").getResultList();


            transactionCommit();
        } catch (Exception e)
        {
            transactionRollback();
        }
        return userlList;
    }

    public void updateUser(Long userId, String userName)
    {
        try
        {
            transactionBegin();
            MainModel user = entityManager.find(MainModel.class, userId);
            user.setUserName(userName);
            transactionCommit();
        } catch (Exception e)
        {
            transactionRollback();
        }
    }


    public void deleteUser(Long userId)
    {
        try
        {
            transactionBegin();

            MainModel user = entityManager.find(MainModel.class, userId);
            entityManager.remove(user);

            transactionCommit();
        } catch (Exception e)
        {
            transactionRollback();
        }
    }

    public MainModel getUserById(Long userId)
    {
        MainModel user = null;
        try
        {
            transactionBegin();
            user = entityManager.find(MainModel.class, userId);
            transactionCommit();
        } catch (Exception e)
        {
            transactionRollback();
        }

        return user;
    }



    private void transactionBegin()
    {
        entityManager.getTransaction().begin();
    }

    private void transactionCommit()
    {
        entityManager.getTransaction().commit();
    }

    private void transactionRollback()
    {
        entityManager.getTransaction().rollback();
    }
}

