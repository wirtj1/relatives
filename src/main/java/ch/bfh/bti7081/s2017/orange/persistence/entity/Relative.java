package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;

/**
 * @author yvesbeutler
 * Representation of a relative who takes care of a {@link Patient}.
 */
@Entity
public class Relative extends Person {
    public Relative() {
        super("No", "Name");
    }
    public Relative(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
