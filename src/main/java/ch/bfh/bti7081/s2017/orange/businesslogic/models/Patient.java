package ch.bfh.bti7081.s2017.orange.businesslogic.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by djboris on 09.05.17.
 */
@Entity
@DiscriminatorValue("P")
public class Patient extends Person{
    @OneToMany
    private List<Insurance> insurances;

    @OneToMany
    private List<Appointment> appointments;
}
