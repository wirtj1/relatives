package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;

/**
 * @author yvesbeutler
 * Representation of a movement to track an outgoing and incoming {@link Patient}.
 */
@Entity
public class Movement extends Identity {
    private static final long serialVersionUID = 1L;

    public Movement() {
        this.arrival = "Montag, 08:00 Uhr";
        this.departure = "Freitag vor Feierabendbier";
        this.note = "Wer das liest, ist dumm!";
    }

    private String arrival;
    private String departure;
    private String note;
}
