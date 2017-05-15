package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author yvesbeutler
 *         INSERT DESCRIPTION HERE
 */
@Entity
public class Address extends Identity {

    @NotNull
    private String streetName;
    private String streetNumber;
    @NotNull
    private String postalCode;
    @NotNull
    private String city;
    private String postBox;
    private String company;
    @NotNull
    private String country;
}
