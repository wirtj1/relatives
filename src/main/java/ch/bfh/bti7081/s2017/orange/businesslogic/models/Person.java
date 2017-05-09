package ch.bfh.bti7081.s2017.orange.businesslogic.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance
@DiscriminatorColumn(name="persontype")
public class Person implements Serializable{
    private String firstName;
    private String lastName;
    private String socialAssuranceNumber;

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialAssuranceNumber() {
        return socialAssuranceNumber;
    }
}
