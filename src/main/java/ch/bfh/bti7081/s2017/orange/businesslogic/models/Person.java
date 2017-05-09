package ch.bfh.bti7081.s2017.orange.businesslogic.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance
@DiscriminatorColumn(name="persontype")
public class Person implements Serializable{
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String socialAssuranceNumber;

    @Enumerated(EnumType.STRING)
    private PersonRole Role;
}
