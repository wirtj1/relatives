package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author yvesbeutler
 * Representation of a patient with his prescribed {@link Medication}.
 */
@Entity
public class Patient extends Person {

    @NotNull
    private String oasi;
    @ManyToMany
    private List<Professional> professionals;
    @ManyToMany
    private List<Insurance> insurances;
    @OneToMany
    private List<Medication> medications;
    @ManyToMany
    private List<Relative> relatives;
    private String goals;
    private String weekendInformation;
    private String yearPlanning;
    @OneToOne
    private Movement movement;
    @OneToOne
    private PinBoard pinBoard;
}
