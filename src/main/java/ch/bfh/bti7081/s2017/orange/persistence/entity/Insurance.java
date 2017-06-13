package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author yvesbeutler
 * Representation of an insurance.
 */
@Entity
public class Insurance extends Identity {
    private static final long serialVersionUID = 1L;

    @NotNull
    private String name;
    @NotNull
    private String policeNumber;
}
