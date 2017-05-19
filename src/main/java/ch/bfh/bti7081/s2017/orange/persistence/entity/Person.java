package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author yvesbeutler
 * Representation of a person. This abstract class is used by {@link Patient},
 * {@link Professional} and {@link Relative}.
 */
public abstract class Person extends Identity {

    private Salutation salutation;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private Date birthdate;
    @OneToOne
    private Address address;
    private String phone;
    private Title title;
}
