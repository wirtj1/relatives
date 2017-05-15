package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;
import java.util.List;

/**
 * @author yvesbeutler
 * Representation of a pinboard which contains of several {@link PinBoardEntry}.
 */
@Entity
public class PinBoard extends Identity {
    private List<PinBoardEntry> entries;
}
