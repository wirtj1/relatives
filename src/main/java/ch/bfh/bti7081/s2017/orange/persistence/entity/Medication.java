package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author yvesbeutler
 * Representation of a medication with the prescribed {@link Medicine}.
 */
@Entity
public class Medication extends Identity {
    private int interval;
    private String dose;
    @NotNull
    private Medicine medicine;
    private String notes;
}
