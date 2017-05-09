package ch.bfh.bti7081.s2017.orange.businesslogic.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

/**
 * Created by djboris on 09.05.17.
 */
@Entity
@DiscriminatorValue("P")
public class Patient extends Person{
    List<Insurance> insurances;
    Calendar calendar;
}
