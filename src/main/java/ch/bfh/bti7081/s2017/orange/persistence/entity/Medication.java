package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * @author yvesbeutler
 * Representation of a medication with the prescribed {@link Medicine}.
 */
@Entity
public class Medication extends Identity {
    private static final long serialVersionUID = 1L;

    private int interval;
    private String dose;
    @NotNull
    @ManyToOne
    private Medicine medicine;

    public Medication(int interval, String dose, Medicine medicine, String notes) {
        this.interval = interval;
        this.dose = dose;
        this.medicine = medicine;
        this.notes = notes;
    }

    public int getInterval() {
        return interval;
    }

    public String getDose() {
        return dose;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public String getNotes() {
        return notes;
    }

    private String notes;
}
