package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * @author yvesbeutler
 * Representation of a single pinboard entry. This allows a direct
 * communication between {@link Relative} and {@link Professional}.
 */
@Entity
public class PinBoardEntry extends Identity {
    private Type type;
    private String message;
    @ManyToOne
    private Person author;
    private Date creationDate;
}
