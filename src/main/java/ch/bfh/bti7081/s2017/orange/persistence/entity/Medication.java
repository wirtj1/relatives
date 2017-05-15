package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author yvesbeutler
 *         INSERT DESCRIPTION HERE
 */
@Entity
public class Medication extends Identity {
    private int interval;
    private String dose;
    @NotNull
    private Medicine medicine;
    private String notes;
}
