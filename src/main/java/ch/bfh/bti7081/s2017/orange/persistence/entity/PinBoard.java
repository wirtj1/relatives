package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yvesbeutler
 *         Representation of a pinboard which contains of several {@link PinBoardEntry}.
 */
@Entity
public class PinBoard extends Identity
{
    private static final long serialVersionUID = 1L;

    @OneToMany
    private List<PinBoardEntry> entries = new ArrayList<>();


    public List<PinBoardEntry> getEntries()
    {
        return entries;
    }

    public void addEntry(PinBoardEntry entry)
    {
        this.entries.add(entry);
    }

    public void addEntries(List<PinBoardEntry> entries)
    {
        this.entries.addAll(entries);
    }

    public void setEntries(List<PinBoardEntry> entries)
    {
        this.entries = entries;
    }
}
