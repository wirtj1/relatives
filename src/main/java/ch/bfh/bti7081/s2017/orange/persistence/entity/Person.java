package ch.bfh.bti7081.s2017.orange.persistence.entity;

import java.util.Date;

/**
 * @author yvesbeutler
 * Representation of a person. This abstract class is used by {@link Patient},
 * {@link Professional} and {@link Relative}.
 */
public abstract class Person extends Identity {

    private Salutation salutation;
    private String firstName;
    private String lasttName;
    private Date birthdate;
    private Address address;
    private String phone;
    private Title title;
}
