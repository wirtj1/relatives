package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author yvesbeutler
 *         INSERT DESCRIPTION HERE
 */
@Entity
public class Account extends Identity {
    private String userName;
    private String password;
    @OneToOne
    private Person person;
    private Permission permission;
}