package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * @author yvesbeutler
 * Representation of professional which can be any kind of medical staff.
 */
@Entity
public class Professional extends Person {
    private boolean onEmergency;
    private Role role;

    public Professional(String firstName, String lastName) {
        super(firstName, lastName);
    }
    protected Professional() { super("", ""); }
}
