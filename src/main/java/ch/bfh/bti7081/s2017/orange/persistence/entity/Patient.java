package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;
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
    private List<Professional> professionals;
    private List<Insurance> insurances;
    private List<Medication> medications;
    private List<Relative> relatives;
    private String goals;
    private String weekendInformation;
    private String yearPlanning;
    private Movement movement;
    private PinBoard pinBoard;
}
