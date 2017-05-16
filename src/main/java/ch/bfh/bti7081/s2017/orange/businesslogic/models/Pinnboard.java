package ch.bfh.bti7081.s2017.orange.businesslogic.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jasmin
 */
public class Pinnboard extends BaseModel
{
    private List<PinnboardEntry> pinnboardEntries;


    public Pinnboard()
    {
        this.pinnboardEntries = new ArrayList<>();
    }

    public List<PinnboardEntry> getLatestEntries()
    {
        return pinnboardEntries;
    }

    public void addEntry(PinnboardEntry pinnboardEntry)
    {
        pinnboardEntries.add(pinnboardEntry);

    }
}
