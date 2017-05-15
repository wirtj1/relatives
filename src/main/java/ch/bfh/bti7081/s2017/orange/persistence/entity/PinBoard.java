package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;
import java.util.List;

/**
 * @author yvesbeutler
 *         INSERT DESCRIPTION HERE
 */
@Entity
public class PinBoard extends Identity {
    private List<PinBoardEntry> entries;
}
