package ch.bfh.bti7081.s2017.orange.presentation.utils;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Account;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Person;
import ch.bfh.bti7081.s2017.orange.persistence.repository.impl.AccountRepository;

import java.util.Date;

/**
 * Representation class for User session
 * @author Sascha
 */
public class Session {

    private Integer TIMEOUT = 60 * 1000 * 5;
    private Account account;
    private Date lastAction;

    public String getUser() {
        return account.getUserName();
    }

    public Person getPerson() {
        return account.getPerson();
    }

    public Session(Account account)
    {
        this.account = account;
        this.lastAction = new Date();
    }

    public void resetTimeout()
    {
        this.lastAction = new Date();
    }

    public Boolean isActive() {
        Date validUntil = new Date(System.currentTimeMillis() - this.TIMEOUT);
        return this.lastAction.after(validUntil);
    }

    public static Session logon(String user, String password){

        AccountRepository repo = new AccountRepository(Account.class);
        Account account = repo.getByNameAndPwd(user, password);
        if (account == null)
            return null;

        return new Session(account);
    }

    public Account getAccount()
    {
        return account;
    }
}
