package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;

/**
 * @author yvesbeutler
 * Representation of a movement to track an outgoing and incoming {@link Patient}.
 */
@Entity
public class Movement extends Identity {
    private String arrival;
    private String departure;
    private String note;
}
