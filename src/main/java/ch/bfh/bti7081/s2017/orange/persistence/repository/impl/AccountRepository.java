package ch.bfh.bti7081.s2017.orange.persistence.repository.impl;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Account;
import ch.bfh.bti7081.s2017.orange.persistence.repository.Repository;

import java.util.List;

/**
 * Created by Sascha on 06/06/2017.
 */
public class AccountRepository extends Repository<Account> {

    public AccountRepository(Class<Account> entityClass) {
        super(entityClass);
    }

    public Account getByNameAndPwd(String user, String password){
        List<Account> accounts = getEm().createQuery("select a from Account a where a.userName = '" + user + "' and a.password = '" + password + "'").getResultList();
        if (accounts.size() <= 0)
            return null;

        return accounts.get(0);
    }
}
