package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;

/**
 * @author yvesbeutler
 * Representation of professional which can be any kind of medical staff.
 */
@Entity
public class Professional extends Person {

    private boolean onEmergency;
    private Role role;
}
