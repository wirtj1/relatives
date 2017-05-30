package ch.bfh.bti7081.s2017.orange.businesslogic.models;

import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoard;
import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoardEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jasmin
 **/
public class PinboardModel extends BaseModel
{

    private PinBoard pinboard;

    public PinboardModel()
    {
        pinboard = new PinBoard();
        pinboard.setEntries(new ArrayList<>());
    }

    public List<PinBoardEntry> getEntries()
    {
        return pinboard.getEntries();
    }

    public void addEntry(PinBoardEntry entry)
    {
        List<PinBoardEntry> entries = getEntries();
        entries.add(entry);
        pinboard.setEntries(entries);
    }


    public PinBoard getPinboard()
    {
        return pinboard;
    }

    public void setPinboard(PinBoard pinboard)
    {
        this.pinboard = pinboard;
    }
}
