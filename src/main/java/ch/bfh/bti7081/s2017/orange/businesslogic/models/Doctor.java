package ch.bfh.bti7081.s2017.orange.businesslogic.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by djboris on 09.05.17.
 */
@Entity
@DiscriminatorValue("D")
public class Doctor extends Person {
}
