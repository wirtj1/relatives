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

    private String userName;
    private String password;
    @OneToOne
    private Person person;
    private Permission permission;
}
