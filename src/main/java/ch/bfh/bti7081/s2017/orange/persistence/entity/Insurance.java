package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author yvesbeutler
 *         INSERT DESCRIPTION HERE
 */
@Entity
public class Insurance extends Identity {
    @NotNull
    private String name;
    @NotNull
    private String policeNumber;
}
