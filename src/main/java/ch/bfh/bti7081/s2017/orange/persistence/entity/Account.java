package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author yvesbeutler
 * Representation of an user account.
 */
@Entity
public class Account extends Identity {
    private static final long serialVersionUID = 1L;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPw) {
        this.password = newPw;
    }

    public Person getPerson() {
        return person;
    }

    public Permission getPermission() {
        return permission;
    }

    private String userName;
    private String password;
    @OneToOne
    private Person person;
    private Permission permission;
}
