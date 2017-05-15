package ch.bfh.bti7081.s2017.orange.persistence.entity;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Address;

import java.util.Date;

/**
 * @author yvesbeutler
 *         INSERT DESCRIPTION HERE
 */
public abstract class Person extends Identity {

    private String name;
    private String firstName;

    private Date birthdate;

    private Address address;
    private String phone;
    private AddressForm addressForm;
    private Title title;


}
