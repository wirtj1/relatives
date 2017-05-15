package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;
import java.util.Date;

/**
 * @author yvesbeutler
 *         INSERT DESCRIPTION HERE
 */
@Entity
public class PinBoardEntry extends Identity {
    private Type type;
    private String message;
    private Person author;
    private Date creationDate;
}
