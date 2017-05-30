package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author yvesbeutler
 *         Representation of a pinboard which contains of several {@link PinBoardEntry}.
 */
@Entity
public class PinBoard extends Identity
{
    @OneToMany
    private List<PinBoardEntry> entries;




    public List<PinBoardEntry> getEntries()
    {
        return entries;
    }

    public void setEntries(List<PinBoardEntry> entries)
    {
        this.entries = entries;
    }
}
